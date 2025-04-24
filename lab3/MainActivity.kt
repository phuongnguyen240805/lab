package com.example.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AQIApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AQIApp() {
    var aqiInput by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val aqiValue = aqiInput.toIntOrNull()
    val (color, label) = remember(aqiInput) {
        when {
            aqiInput.isEmpty() -> Pair(Color.Gray, "Nhập giá trị AQI")
            aqiValue == null -> {
                errorMessage = "Vui lòng nhập số hợp lệ"
                Pair(Color.Gray, "Không hợp lệ")
            }
            aqiValue < 0 -> {
                errorMessage = "AQI không thể âm"
                Pair(Color.Gray, "Không hợp lệ")
            }
            aqiValue > 500 -> {
                errorMessage = "AQI quá lớn (tối đa 500)"
                Pair(Color.Gray, "Không hợp lệ")
            }
            else -> {
                errorMessage = null
                when (aqiValue) {
                    in 0..50 -> Pair(Color(0xFF4CAF50), "Tốt")
                    in 51..100 -> Pair(Color(0xFFFFEB3B), "Trung bình")
                    in 101..150 -> Pair(Color(0xFFFF9800), "Kém")
                    in 151..200 -> Pair(Color(0xFFF44336), "Xấu")
                    else -> Pair(Color(0xFF9C27B0), "Nguy hiểm")
                }
            }
        }
    }

    // bo cuc man hinh
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Ứng Dụng AQI", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
            }
        )

        // input text
        OutlinedTextField(
            value = aqiInput,
            onValueChange = { aqiInput = it },
            placeholder = { Text("Nhập chỉ số AQI", color = Color.Gray) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            isError = errorMessage != null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shape = MaterialTheme.shapes.medium,
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            )
        )

        // Hiển thị thông báo lỗi nếu có
        errorMessage?.let {
            Text(
                text = it,
                color = Color.Red,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color, shape = MaterialTheme.shapes.medium)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = label,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAQIApp() {
    AQIApp()
}
