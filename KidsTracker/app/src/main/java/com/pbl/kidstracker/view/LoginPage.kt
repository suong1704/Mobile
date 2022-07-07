package com.pbl.kidstracker

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginPage() {

    val scrollState = rememberScrollState()
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .verticalScroll(scrollState)
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                .background(Color.White)
                .padding(10.dp)

        ){

            Image(
                painter = painterResource(id = R.drawable.images),
                contentDescription = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            OutlinedTextField(
                value = emailValue.value,
                onValueChange = {emailValue.value = it },
                label = { Text("Email Address") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                leadingIcon = {
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_email_24), contentDescription = "icon_email")
                },
            )
            OutlinedTextField(
                value = passwordValue.value,
                onValueChange = { passwordValue.value = it },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .focusRequester(focusRequester = focusRequester),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_key_24), contentDescription = "icon_Password")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = "icon_iye"
                        )
                    }
                },
                singleLine = true,
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                else PasswordVisualTransformation(),

            )
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
            ) {
                Text(text = "Sign In", fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Create New Account",
                modifier = Modifier.clickable(onClick = {

                })
            )
        }
    }
}
@Preview
@Composable
fun LoginPagePreview(){
//    LoginPage()
}
@Composable
fun RegisterPage() {

    val scrollState = rememberScrollState()
    val emailValue = remember { mutableStateOf("") }
    val nameValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordConfirmValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .verticalScroll(scrollState)
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                .background(Color.White)
                .padding(10.dp)

        ){

            Image(
                painter = painterResource(id = R.drawable.sign_up),
                contentDescription = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            OutlinedTextField(
                value = nameValue.value,
                onValueChange = {nameValue.value = it },
                label = { Text("Name") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_person_24), contentDescription = "icon_email")
                },
            )
            OutlinedTextField(
                value = emailValue.value,
                onValueChange = {emailValue.value = it },
                label = { Text("Email Address") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_email_24), contentDescription = "icon_email")
                },
            )
            OutlinedTextField(
                value = passwordValue.value,
                onValueChange = { passwordValue.value = it },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .focusRequester(focusRequester = focusRequester),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_key_24), contentDescription = "icon_Password")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = "icon_eye"
                        )
                    }
                },
                singleLine = true,
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                else PasswordVisualTransformation(),

                )
            OutlinedTextField(
                value = passwordConfirmValue.value,
                onValueChange = { passwordConfirmValue.value = it },
                label = { Text("Confirm Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .focusRequester(focusRequester = focusRequester),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_key_24), contentDescription = "icon_Password")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = "icon_eye_1"
                        )
                    }
                },
                singleLine = true,
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                else PasswordVisualTransformation(),

                )
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
            ) {
                Text(text = "Sign Up", fontSize = 20.sp)
            }
        }
    }
}
@Preview
@Composable
fun RegisterPagePreview(){
    RegisterPage()
}


