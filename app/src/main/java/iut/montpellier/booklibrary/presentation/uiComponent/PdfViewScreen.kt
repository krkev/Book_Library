package iut.montpellier.booklibrary.presentation.uiComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberVerticalPdfReaderState

@Composable
fun PdfViewScreen(
    url: String
) {
    var isDarkMode by remember { mutableStateOf(false) }
    val pdfState = rememberVerticalPdfReaderState(resource = ResourceType.Remote(url), isZoomEnable = true)
    VerticalPDFReader(state = pdfState, modifier = Modifier.fillMaxSize().background(Color.Gray))
}