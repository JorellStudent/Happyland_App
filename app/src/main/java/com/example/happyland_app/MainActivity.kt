package com.example.happyland_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                // Pantalla de inicio de sesión
                LoginScreen()
                // Puedes cambiar a MainScreen() cuando ya hayas implementado la navegación.
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
                text = "Welcome Back",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFFF5722) // Color naranja similar al de la imagen
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Email
            InputField(iconId = R.drawable.email, hint = "Email")

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Password
            InputField(iconId = R.drawable.password, hint = "Password", isPassword = true)

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
            onValueChange = {},
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
        text = "Are you new user? Register",
        color = Color.Blue,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Happyland_AppTheme {
        LoginScreen()
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
            // Sección de encabezado
            HeaderSection()

            Spacer(modifier = Modifier.height(20.dp))

            // Sección de botones de acceso rápido
            QuickAccessButtons()

            Spacer(modifier = Modifier.height(20.dp))

            // Barra de búsqueda
            SearchBar()

            Spacer(modifier = Modifier.height(20.dp))

            // Banner de "Upgrade Your Account"
            UpgradeBanner()

            Spacer(modifier = Modifier.height(20.dp))

            // Sección de botones en grid
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
                text = "Hello",
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        QuickAccessButton(iconId = R.drawable.video_call, label = "Video Call")
        QuickAccessButton(iconId = R.drawable.notification, label = "Notification")
        QuickAccessButton(iconId = R.drawable.voice_call, label = "Voice Call")
    }
}

@Composable
fun QuickAccessButton(iconId: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = iconId), // Reemplaza con el ícono adecuado
            contentDescription = label,
            modifier = Modifier.size(64.dp)
        )
        Text(text = label, fontSize = 12.sp)
    }
}

@Composable
fun SearchBar() {
    BasicTextField(
        value = remember { TextFieldValue("") },
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(48.dp)
            .background(Color.LightGray, CircleShape)
            .padding(horizontal = 16.dp),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                innerTextField()
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.search_icon), // Reemplaza con tu ícono
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    )
}

@Composable
fun UpgradeBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color(0xFFDEEAFD), CircleShape)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "To Get Unlimited\nUpgrade Your Account", fontSize = 16.sp)
    }
}

@Composable
fun GridButtons() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        val gridItems = listOf(
            Pair(R.drawable.ic_1, "Inbox"),
            Pair(R.drawable.ic_2, "Maps"),
            Pair(R.drawable.ic_3, "Chats"),
            Pair(R.drawable.ic_4, "Report"),
            Pair(R.drawable.ic_5, "Calendar"),
            Pair(R.drawable.ic_6, "Tips"),
            Pair(R.drawable.ic_7, "Settings"),
            Pair(R.drawable.ic_8, "More")
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
