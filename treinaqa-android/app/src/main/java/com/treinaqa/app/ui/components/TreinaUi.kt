package com.treinaqa.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.treinaqa.app.ui.seletores.Seletor
import com.treinaqa.app.ui.seletores.Seletores
import com.treinaqa.app.ui.seletores.seletor
import com.treinaqa.app.ui.seletores.seletorCampo
import com.treinaqa.app.ui.seletores.seletorErro
import com.treinaqa.app.ui.theme.TreinaColors

@Composable
fun BrandLogo(
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    marcaSeletor: Seletor = Seletores.tituloMarca,
    subtitleTag: Seletor? = null,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = TreinaColors.Ink, fontWeight = FontWeight.ExtraBold)) {
                    append("treina")
                }
                withStyle(SpanStyle(color = TreinaColors.Accent, fontWeight = FontWeight.ExtraBold)) {
                    append("QA")
                }
            },
            fontSize = 42.sp,
            letterSpacing = (-1).sp,
            lineHeight = 44.sp,
            modifier = Modifier.seletor(marcaSeletor),
        )
        if (subtitle != null) {
            Spacer(Modifier.height(8.dp))
            Text(
                text = subtitle,
                color = TreinaColors.InkSoft,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = subtitleTag?.let { Modifier.seletor(it) } ?: Modifier,
            )
        }
    }
}

@Composable
fun AuthCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier
            .widthIn(max = 440.dp)
            .fillMaxWidth()
            .shadow(12.dp, RoundedCornerShape(16.dp), ambientColor = Color(0x14141820), spotColor = Color(0x14141820))
            .clip(RoundedCornerShape(16.dp))
            .background(TreinaColors.Paper)
            .padding(horizontal = 22.dp, vertical = 24.dp),
        content = content,
    )
}

@Composable
fun TreinaField(
    seletor: Seletor,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    erro: String? = null,
    /** Emoji à esquerda do campo (ex.: "✉️") — inclui espaço após o emoji. */
    leadingEmoji: String? = null,
    leadingIcon: ImageVector? = null,
    leadingIconTint: Color = TreinaColors.Accent,
    trailing: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    focusRequester: FocusRequester? = null,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    enabled: Boolean = true,
) {
    Column(modifier = modifier.fillMaxWidth().padding(bottom = 12.dp)) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            color = TreinaColors.Ink,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 6.dp),
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder?.let { { Text(it, color = TreinaColors.InkSoft) } },
            isError = erro != null,
            singleLine = singleLine,
            readOnly = readOnly,
            enabled = enabled,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            leadingIcon = when {
                leadingEmoji != null -> {
                    {
                        Text(
                            text = "$leadingEmoji ",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 2.dp),
                        )
                    }
                }
                leadingIcon != null -> {
                    {
                        Icon(
                            leadingIcon,
                            contentDescription = null,
                            tint = leadingIconTint,
                            modifier = Modifier.size(20.dp),
                        )
                    }
                }
                else -> null
            },
            trailingIcon = trailing,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = TreinaColors.Ink,
                unfocusedBorderColor = TreinaColors.LineStrong,
                errorBorderColor = TreinaColors.Danger,
                focusedContainerColor = TreinaColors.Paper,
                unfocusedContainerColor = TreinaColors.Paper,
                cursorColor = TreinaColors.Ink,
                errorCursorColor = TreinaColors.Danger,
                focusedLabelColor = TreinaColors.Ink,
                errorLabelColor = TreinaColors.Danger,
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .seletorCampo(seletor)
                .then(if (focusRequester != null) Modifier.focusRequester(focusRequester) else Modifier),
        )
        if (erro != null) {
            Text(
                text = erro,
                color = TreinaColors.Danger,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .seletorErro(seletor),
            )
        }
    }
}

/**
 * Combo de UF — resource-id no próprio controle clicável (Appium).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EstadoComboField(
    seletor: Seletor,
    listaSeletor: Seletor,
    valor: String,
    expandido: Boolean,
    onExpandChange: (Boolean) -> Unit,
    opcoes: List<String>,
    opcaoSeletor: (String) -> Seletor,
    onSelecionar: (String) -> Unit,
    isError: Boolean = false,
    onDismiss: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    ExposedDropdownMenuBox(
        expanded = expandido,
        onExpandedChange = onExpandChange,
        modifier = modifier.fillMaxWidth(),
    ) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = TreinaColors.Paper,
            border = BorderStroke(
                width = 1.dp,
                color = if (isError) TreinaColors.Danger else TreinaColors.LineStrong,
            ),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .height(56.dp)
                .seletorCampo(seletor),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    text = if (valor.isBlank()) "Selecione o estado" else valor,
                    color = if (valor.isBlank()) TreinaColors.InkSoft else TreinaColors.Ink,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f),
                )
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    tint = TreinaColors.InkSoft,
                )
            }
        }
        ExposedDropdownMenu(
            expanded = expandido,
            onDismissRequest = {
                onExpandChange(false)
                onDismiss?.invoke()
            },
            modifier = Modifier
                .heightIn(max = 280.dp)
                .seletor(listaSeletor),
        ) {
            opcoes.forEach { uf ->
                val opcao = opcaoSeletor(uf)
                DropdownMenuItem(
                    text = { Text(uf) },
                    onClick = { onSelecionar(uf) },
                    modifier = Modifier.seletor(opcao),
                )
            }
        }
    }
}

@Composable
fun OutlineActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    seletor: Seletor? = null,
) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        border = BorderStroke(1.5.dp, TreinaColors.LineStrong),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = TreinaColors.Ink,
            disabledContentColor = TreinaColors.InkSoft,
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = (seletor?.let { modifier.seletor(it) } ?: modifier)
            .fillMaxWidth()
            .height(52.dp),
    ) {
        Text(text, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Composable
fun PrimaryActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    seletor: Seletor? = null,
) {
    val tagged = seletor?.let { modifier.seletorCampo(it) } ?: modifier
    Surface(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        color = if (enabled) TreinaColors.Ink else TreinaColors.Line,
        contentColor = if (enabled) Color.White else TreinaColors.InkSoft,
        shadowElevation = if (enabled) 2.dp else 0.dp,
        modifier = tagged
            .fillMaxWidth()
            .height(52.dp),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
        ) {
            Text(text, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

@Composable
fun ErrorBanner(
    message: String,
    seletor: Seletor,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(TreinaColors.DangerSoft)
            .padding(horizontal = 14.dp, vertical = 12.dp)
            .seletor(seletor),
    ) {
        Text(message, color = TreinaColors.Danger, fontWeight = FontWeight.Medium, fontSize = 14.sp)
    }
}

@Composable
fun LinkTextButton(
    text: String,
    onClick: () -> Unit,
    seletor: Seletor,
    modifier: Modifier = Modifier,
) {
    TextButton(onClick = onClick, modifier = modifier.seletor(seletor)) {
        Text(text, color = TreinaColors.Ink, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun PasswordTrailing(
    visible: Boolean,
    enabled: Boolean,
    onToggle: () -> Unit,
    seletor: Seletor,
    visibleIcon: ImageVector,
    hiddenIcon: ImageVector,
) {
    IconButton(
        onClick = onToggle,
        enabled = enabled,
        modifier = Modifier.seletor(seletor),
    ) {
        Icon(
            imageVector = if (visible) visibleIcon else hiddenIcon,
            contentDescription = null,
            tint = if (visible) Color(0xFF2E7D32) else TreinaColors.InkSoft,
        )
    }
}

@Composable
fun PageFooter(
    text: String = "Aplicativo criado pelo chefinho do teste Aparecido",
    modifier: Modifier = Modifier,
    seletor: Seletor? = null,
) {
    Text(
        text = text,
        color = TreinaColors.InkSoft.copy(alpha = 0.75f),
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .then(seletor?.let { Modifier.seletor(it) } ?: Modifier)
            .padding(horizontal = 12.dp, vertical = 10.dp),
    )
}

/** Rodapé fixo acima dos botões nativos do Android. */
@Composable
fun SafeBottomFooter(
    modifier: Modifier = Modifier,
    text: String = "Aplicativo criado pelo chefinho do teste Aparecido",
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(bottom = 4.dp),
        contentAlignment = Alignment.Center,
    ) {
        PageFooter(text = text)
    }
}

@Composable
fun BackButton(
    onClick: () -> Unit,
    seletor: Seletor,
    modifier: Modifier = Modifier,
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val bg = if (pressed) TreinaColors.Accent else TreinaColors.Paper
    val fg = if (pressed) Color.White else TreinaColors.Ink
    val border = if (pressed) TreinaColors.Accent else TreinaColors.LineStrong

    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(999.dp),
        color = bg,
        contentColor = fg,
        border = BorderStroke(1.5.dp, border),
        shadowElevation = if (pressed) 0.dp else 2.dp,
        interactionSource = interaction,
        modifier = modifier.seletor(seletor),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = fg,
                modifier = Modifier.size(18.dp),
            )
            Spacer(Modifier.width(6.dp))
            Text(
                text = "Voltar",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = fg,
            )
        }
    }
}

@Composable
fun FormStickyActions(
    modifier: Modifier = Modifier,
    showFooter: Boolean = true,
    rodapeSeletor: Seletor? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(
        color = TreinaColors.Paper,
        shadowElevation = 10.dp,
        tonalElevation = 2.dp,
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 440.dp)
                    .padding(horizontal = 16.dp)
                    .padding(top = 14.dp, bottom = if (showFooter) 6.dp else 14.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = content,
            )
            if (showFooter) {
                PageFooter(seletor = rodapeSeletor)
            }
        }
    }
}

@Composable
fun SectionLabel(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 10.dp),
    ) {
        Text(text, fontWeight = FontWeight.Bold, color = TreinaColors.Ink, fontSize = 14.sp)
    }
}
