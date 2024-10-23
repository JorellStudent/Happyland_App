package com.example.happyland_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happyland_app.ui.theme.Happyland_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Happyland_AppTheme {
                // Pantalla de registro para pruebas
                MainScreen() // Cambia a LoginScreen() o MainScreen() según sea necesario.
            }
        }
    }
}

@Composable
fun LoginScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Fondo decorativo
            BackgroundDecor()

            Spacer(modifier = Modifier.height(32.dp))

            // Texto "Welcome Back"
            Text(
                text = "Bienvenido a la HappyApp",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFFF5722) // Color naranja
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Email
            InputField(iconId = R.drawable.email, hint = "Email")

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Password
            InputField(iconId = R.drawable.password, hint = "Contraseña", isPassword = true)

            Spacer(modifier = Modifier.height(32.dp))

            // Botón de inicio de sesión (flecha)
            LoginButton()

            Spacer(modifier = Modifier.height(32.dp))

            // Botones de Google y Facebook
            SocialLoginButtons()

            Spacer(modifier = Modifier.height(16.dp))

            // Texto de registro
            RegisterText()
        }
    }
}

@Composable
fun BackgroundDecor() {
    // Fondo decorativo personalizado que cubre la parte superior de la pantalla
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.LightGray) // Cambia esto con una imagen de fondo si tienes alguna.
    ) {
        Image(
            painter = painterResource(id = R.drawable.top_background), // Reemplaza con tu imagen de fondo si tienes una.
            contentDescription = "Decorative Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun InputField(iconId: Int, hint: String, isPassword: Boolean = false) {
    val textState = remember { TextFieldValue("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .background(Color.LightGray.copy(alpha = 0.5f)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.size(24.dp).padding(8.dp)
        )
        BasicTextField(
            value = textState,
            onValueChange = { /* Aquí podrías manejar el cambio de texto */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    innerTextField()
                    if (textState.text.isEmpty()) {
                        Text(
                            text = hint,
                            color = Color.Gray
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun LoginButton() {
    Button(
        onClick = { /* Acción de inicio de sesión */ },
        shape = CircleShape,
        modifier = Modifier.size(64.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.btn_arraw1), // Reemplaza con el ícono adecuado
            contentDescription = "Login",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun SocialLoginButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { /* Acción de inicio de sesión con Google */ }) {
            Icon(painter = painterResource(id = R.drawable.google), contentDescription = "Google")
        }
        Button(onClick = { /* Acción de inicio de sesión con Facebook */ }) {
            Icon(painter = painterResource(id = R.drawable.facebook), contentDescription = "Facebook")
        }
    }
}

@Composable
fun RegisterText() {
    Text(
        text = "Are you a new user? Register",
        color = Color.Blue,
        modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = { /* Navegar a RegisterScreen */ })
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Happyland_AppTheme {
        LoginScreen()
    }
}

// Pantalla de Registro
@Composable
fun RegisterScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Fondo decorativo
            BackgroundDecor()

            Spacer(modifier = Modifier.height(32.dp))

            // Texto "Create an Account"
            Text(
                text = "Create an Account",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFFF5722) // Color naranja
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Nombre
            InputField(iconId = R.drawable.name, hint = "Name") // Usa un ícono adecuado

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Email
            InputField(iconId = R.drawable.email, hint = "Email")

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Password
            InputField(iconId = R.drawable.password, hint = "Password", isPassword = true)

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Confirmación de Password
            InputField(iconId = R.drawable.password, hint = "Confirm Password", isPassword = true)

            Spacer(modifier = Modifier.height(32.dp))

            // Botón de registro
            RegisterButton()

            Spacer(modifier = Modifier.height(32.dp))

            // Texto de inicio de sesión
            LoginText()
        }
    }
}

@Composable
fun RegisterButton() {
    Button(
        onClick = { /* Acción de registro */ },
        shape = CircleShape,
        modifier = Modifier.size(64.dp)
    ) {
        Text(text = "Register", fontSize = 16.sp)
    }
}

@Composable
fun LoginText() {
    Text(
        text = "Already have an account? Login",
        color = Color.Blue,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    Happyland_AppTheme {
        RegisterScreen()
    }
}

// Aquí empieza el código para el Dashboard (MainScreen)
@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            HeaderSection()

            Spacer(modifier = Modifier.height(20.dp))

            QuickAccessButtons()

            Spacer(modifier = Modifier.height(20.dp))

            SearchBar()

            Spacer(modifier = Modifier.height(20.dp))

            UpgradeBanner()

            Spacer(modifier = Modifier.height(20.dp))

            GridButtons()
        }
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Hola",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray
            )
            Text(
                text = "Happylander",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Image(
            painter = painterResource(id = R.drawable.profile), // Reemplaza con tu imagen de perfil
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(64.dp)
                .background(Color.LightGray, CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun QuickAccessButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { /* Acción 1 */ }) {
            Text("Recargar")
        }
        Button(onClick = { /* Acción 2 */ }) {
            Text("Canjear")
        }
        Button(onClick = { /* Acción 3 */ }) {
            Text("Camára")
        }
    }
}

@Composable
fun SearchBar() {
    Box(modifier = Modifier.padding(16.dp)) {
        BasicTextField(
            value = TextFieldValue("Busqueda..."),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, CircleShape)
                .padding(16.dp),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    innerTextField()
                    // Aquí podrías agregar un ícono de búsqueda
                }
            }
        )
    }
}

@Composable
fun UpgradeBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color(0xFFFFEB3B))
            .padding(16.dp)
    ) {
        Text(text = "Agrega tu tarjeta Aqui!!", color = Color.Black)
    }
}

@Composable
fun GridButtons() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        val gridItems = listOf(
            Pair(R.drawable.ic_1, "Formularios"),
            Pair(R.drawable.ic_2, "Mapas"),
            Pair(R.drawable.ic_3, "Chats"),
            Pair(R.drawable.ic_4, "Reportes"),
            Pair(R.drawable.ic_5, "Cumpleaños"),
            Pair(R.drawable.ic_6, "Tips"),
            Pair(R.drawable.ic_7, "Configuración"),
            Pair(R.drawable.ic_8, "Otros")
        )

        // Crear filas para los íconos
        gridItems.chunked(4).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                rowItems.forEach { (iconId, label) ->
                    GridButton(iconId = iconId, label = label)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun GridButton(iconId: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = iconId), // Reemplaza con el ícono adecuado
            contentDescription = label,
            modifier = Modifier.size(48.dp)
        )
        Text(text = label, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Happyland_AppTheme {
        MainScreen()
    }
}

@Composable
fun SettingsScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp) // Margen general de la pantalla
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // Encabezado de ajustes
                Text(
                    text = "Configuración",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFFFF5722) // Color naranja
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Opción de notificaciones
                SettingItem(title = "Activar Notficaciones", defaultChecked = true)

                Spacer(modifier = Modifier.height(20.dp))

                // Opción de modo oscuro
                SettingItem(title = "Modo Oscuro", defaultChecked = false)

                Spacer(modifier = Modifier.height(20.dp))

                // Opción de sonido
                SettingItem(title = "Habilitar Sonido", defaultChecked = true)
            }

            // Botón de regresar en la parte inferior derecha
            Button(
                onClick = { /* Acción de regreso no funcional */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Alinea el botón en la parte inferior derecha
                    .padding(16.dp)
            ) {
                Text(text = "Atrás", color = Color.Black)
            }
        }
    }
}

@Composable
fun SettingItem(title: String, defaultChecked: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
        Switch(
            checked = defaultChecked,
            onCheckedChange = { /* Manejar el cambio de estado aquí */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    Happyland_AppTheme {
        SettingsScreen()
    }
}

@Composable
fun InboxScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // Encabezado del Inbox
                Text(
                    text = "Chat",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFFFF5722),
                    modifier = Modifier
                        .padding(16.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Lista de mensajes
                MessageList()

                Spacer(modifier = Modifier.height(10.dp))

                // Sección del asistente para enviar mensajes
                AssistantInput()
            }

            // Botón de regresar en la parte inferior derecha
            Button(
                onClick = { /* Acción de regreso no funcional */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Alinea el botón en la parte inferior derecha
                    .padding(16.dp)
            ) {
                Text(text = "Back", color = Color.Black)
            }
        }
    }
}

@Composable
fun MessageList() {
    val messages = listOf(
        "Hola, ¿en qué puedo ayudarte?",
        "¿Tienes alguna pregunta?",
        "Recuerda que puedes verificar tus configuraciones en el menú de ajustes."
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        messages.forEach { message ->
            MessageItem(message = message, isUser = false)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MessageItem(message: String, isUser: Boolean) {
    val backgroundColor = if (isUser) Color(0xFF2196F3) else Color(0xFFE0E0E0)
    val textColor = if (isUser) Color.White else Color.Black

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor, shape = CircleShape)
            .padding(16.dp)
    ) {
        Text(text = message, color = textColor)
    }
}

@Composable
fun AssistantInput() {
    var inputText = remember { TextFieldValue("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Campo de texto para enviar un mensaje al asistente
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, CircleShape)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = inputText,
                onValueChange = { newText -> inputText = newText },
                modifier = Modifier.weight(1f),
                decorationBox = { innerTextField ->
                    if (inputText.text.isEmpty()) {
                        Text(text = "Escribe un mensaje...", color = Color.Gray)
                    }
                    innerTextField()
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            // Botón de enviar
            Button(onClick = { /* Aquí enviarías el mensaje al asistente */ }) {
                Text("Enviar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InboxScreenPreview() {
    Happyland_AppTheme {
        InboxScreen()
    }
}

@Composable
fun ReportScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // Título de la pantalla de reportes
                Text(
                    text = "Reportes",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFFFF5722)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Subtítulo para el reporte de visitas
                Text(
                    text = "Visitors in the last week",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Gráfico de barras simulado
                BarChart(
                    data = listOf(120, 150, 100, 200, 180, 220, 300),
                    labels = listOf("L", "M", "X", "J", "V", "S", "D")
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Otro ejemplo de gráfico o estadísticas (puedes agregar más si lo necesitas)
                Text(
                    text = "Promedio de visitantes por día: 180",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
            }

            // Botón de regresar en la parte inferior derecha
            Button(
                onClick = { /* Acción de regreso no funcional */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Alinea el botón en la parte inferior derecha
                    .padding(16.dp)
            ) {
                Text(text = "Atrás", color = Color.Black)
            }
        }
    }
}


@Composable
fun BarChart(data: List<Int>, labels: List<String>) {
    val maxDataValue = data.maxOrNull() ?: 0

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        data.forEachIndexed { index, value ->
            // Fila para cada barra del gráfico
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Etiqueta del día
                Text(
                    text = labels[index],
                    modifier = Modifier.width(40.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(8.dp))

                // Barra del gráfico, con una anchura proporcional al valor de los datos
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .width((value * 2).dp) // Aquí escalamos el valor para hacer la barra más visible
                        .background(Color(0xFF2196F3))
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Valor numérico al final de la barra
                Text(
                    text = "$value",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReportScreenPreview() {
    Happyland_AppTheme {
        ReportScreen()
    }
}

@Composable
fun TipsScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // Título de la pantalla de tips
                Text(
                    text = "Happyland Tips",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFFFF5722)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Lista de consejos (tips)
                TipItem(
                    title = "Personal siempre dispuesto a ayudar",
                    description = "Si tienes algún problema o pregunta, nuestro personal estará feliz de asistirte en cualquier momento."
                )

                Spacer(modifier = Modifier.height(16.dp))

                TipItem(
                    title = "Canjea tus tickets",
                    description = "¡No olvides canjear tus tickets en la tienda de premios para llevarte sorpresas a casa!"
                )

                Spacer(modifier = Modifier.height(16.dp))

                TipItem(
                    title = "Promociones los miércoles",
                    description = "¡Aprovecha los miércoles de promoción con descuentos especiales para toda la familia!"
                )

                Spacer(modifier = Modifier.height(16.dp))

                TipItem(
                    title = "Consejos de seguridad",
                    description = "Mantén a tus pequeños siempre a la vista y sigue las indicaciones del parque para disfrutar de forma segura."
                )

                Spacer(modifier = Modifier.height(16.dp))

                TipItem(
                    title = "¡Diviértete al máximo!",
                    description = "Recuerda que lo más importante es pasar un día lleno de diversión junto a tus seres queridos."
                )
            }

            // Botón de regresar en la parte inferior derecha
            Button(
                onClick = { /* Acción de regreso no funcional */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Alinea el botón en la parte inferior derecha
                    .padding(16.dp)
            ) {
                Text(text = "Atrás", color = Color.Black)
            }
        }
    }
}


@Composable
fun TipItem(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Título del tip
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF2196F3)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Descripción del tip
        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TipsScreenPreview() {
    Happyland_AppTheme {
        TipsScreen()
    }
}

@Composable
fun CalendarScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // Título de la pantalla del calendario
                Text(
                    text = "Calendario",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFFFF5722)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Días de la semana
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    listOf("Lun", "Mar", "Mie", "Jue", "Vie", "Sab", "Dom").forEach { day ->
                        Text(
                            text = day,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Días del mes (ejemplo de mes estático)
                Column {
                    val daysInMonth = listOf(
                        listOf(1, 2, 3, 4, 5, 6, 7),
                        listOf(8, 9, 10, 11, 12, 13, 14),
                        listOf(15, 16, 17, 18, 19, 20, 21),
                        listOf(22, 23, 24, 25, 26, 27, 28),
                        listOf(29, 30, 31)
                    )

                    daysInMonth.forEach { week ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            week.forEach { day ->
                                DayItem(day = day.toString())
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            // Botón de regresar en la parte inferior derecha
            Button(
                onClick = { /* Acción de regreso no funcional */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text(text = "Atrás", color = Color.Black)
            }
        }
    }
}

@Composable
fun DayItem(day: String) {
    Box(
        modifier = Modifier
            .size(40.dp) // Tamaño del día
            .background(Color.LightGray, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(text = day, color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarScreenPreview() {
    Happyland_AppTheme {
        CalendarScreen()
    }
}

@Composable
fun MapScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // Título de la pantalla del mapa
                Text(
                    text = "Mapa de Arica",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFFFF5722)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Mostrar el mapa
                Image(
                    painter = painterResource(id = R.drawable.arica), // Reemplaza con el nombre de tu imagen
                    contentDescription = "Mapa de Arica",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp) // Ajusta la altura según sea necesario
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            // Botón de regresar en la parte inferior derecha
            Button(
                onClick = { /* Acción de regreso no funcional */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text(text = "Atrás", color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    Happyland_AppTheme {
        MapScreen()
    }
}

@Composable
fun RegisterCardScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // Título de la pantalla de registro de tarjeta
                Text(
                    text = "Registrar Código de Serie",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFFFF5722),
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Campo de texto para ingresar el código de serie
                TextField(
                    value = "",
                    onValueChange = { /* Aquí puedes manejar el texto ingresado */ },
                    label = { Text("Código de serie") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Botón para registrar el código
                Button(
                    onClick = { /* Acción para registrar el código */ },
                    modifier = Modifier.align(Alignment.End) // Alinea el botón a la derecha
                ) {
                    Text("Registrar")
                }
            }

            // Botón de regresar en la parte inferior derecha
            Button(
                onClick = { /* Acción de regreso no funcional */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text(text = "Back", color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterCardScreenPreview() {
    Happyland_AppTheme {
        RegisterCardScreen()
    }
}