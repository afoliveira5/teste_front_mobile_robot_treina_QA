package com.treinaqa.app.ui.seletores

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics

/** id → resource-id (Appium). cssSelector/xpath ficam só no [Seletor]. */
fun Modifier.seletor(s: Seletor): Modifier = this.testTag(s.id)

/**
 * Para campos de formulário (TextField / combo).
 * mergeDescendants faz o EditText interno expor o mesmo resource-id.
 * NÃO usar em containers da tela inteira.
 */
fun Modifier.seletorCampo(s: Seletor): Modifier =
    this
        .semantics(mergeDescendants = true) {}
        .testTag(s.id)

fun Modifier.seletorErro(s: Seletor): Modifier = this.testTag(s.erroId)
