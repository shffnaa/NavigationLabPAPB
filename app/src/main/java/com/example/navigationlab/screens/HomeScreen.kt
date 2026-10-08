package com.example.navigationlab.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onOpenDetail: (Int) -> Unit,
    onOpenProfile: () -> Unit,
    onOpenAbout: () -> Unit //tugas praktikum
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(onClick = { onOpenDetail(101) }) {
            Text("Buka Detail Mahasiswa 101")
        }

        OutlinedButton(onClick = onOpenProfile) {
            Text("Buka Profile")
        }
        //tombol buka (tugas praktikum)
        OutlinedButton(onClick = onOpenAbout) {
            Text("Buka About")
        }
    }
}