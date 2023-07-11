package com.example.pdf_viewer

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.pdf_viewer.ui.theme.Pdf_viewerTheme
import com.github.barteksc.pdfviewer.PDFView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pdf_viewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeWithXML()
                }
            }
        }
    }
}

@Composable
fun ComposeWithXML() {
    AndroidView(
        factory = {
            View.inflate(it, R.layout.main_layout, null)
        },
        modifier = Modifier.fillMaxSize(),
        update = {
            val pdfView =  it.findViewById<PDFView>(R.id.pdfviewer)

            pdfView.fromAsset("Chapter1.pdf").enableSwipe(true).swipeHorizontal(false).load()
        }
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pdf_viewerTheme {
        ComposeWithXML()
    }
}