package com.example.add_name.Add_name

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AddName(padding: PaddingValues, modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }
    var names by remember { mutableStateOf(listOf("")) }

    Column(
        modifier
            .padding(padding)
            .padding(horizontal = 10.dp)
            .fillMaxSize()
    ) {
        Row {
            OutlinedTextField(
                value = name,
                onValueChange = { i ->
                    if (i.isNotEmpty()) {
                        name = i
                    }
                },
                modifier
                    .weight(1f)
                    .padding(end = 5.dp),
                placeholder = { Text("Name Please...") },
                singleLine = true
            )
            Button(onClick = {
                if (names.isNotEmpty()) {
                    names = names + name
                    name = ""
                }
            }) {
                Text("Add Name")
            }
        }

        LazyColumn(modifier.padding(top = 10.dp)) {
            items(names) { name ->
                if (name.isNotBlank()) {
                    Text(name, modifier.padding(vertical = 5.dp))
                    HorizontalDivider(thickness = 2.dp, modifier = modifier.padding(bottom = 5.dp))
                }
            }
        }

    }
}