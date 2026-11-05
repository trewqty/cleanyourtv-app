package tv.cleanyour.app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tv.cleanyour.ui.design.theme.CytTheme

// Edit these constants: this is the whole advert.
object ShopPromoConfig {
    const val SHOW_ON_EVERY_START = true          // false = show only on the first launch after install
    const val SHOP_NAME = "Магазин B13"
    const val MARKET = "Рынок Малика, Ташкент"
    const val PITCH = "Магазин B13 — ваш надёжный выбор."   // TODO: what the shop sells
    const val PHONE = "+998 90 927 66 67"                  // TODO: father's phone number
}

/** Full-screen welcome card with the shop advert. [onContinue] opens the normal app. */
@Composable
fun ShopPromoScreen(onContinue: () -> Unit) {
    val c = CytTheme.colors
    Box(
        Modifier.fillMaxSize().background(c.bg).padding(24.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(c.surface2)
                .padding(28.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BasicText(
                ShopPromoConfig.SHOP_NAME,
                style = TextStyle(color = c.textPrimary, fontSize = 30.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
            )
            BasicText(
                ShopPromoConfig.MARKET,
                style = TextStyle(color = c.accent, fontSize = 18.sp, textAlign = TextAlign.Center),
            )
            BasicText(
                ShopPromoConfig.PITCH,
                style = TextStyle(color = c.textSecondary, fontSize = 16.sp, textAlign = TextAlign.Center),
            )
            BasicText(
                "Тел.: ${ShopPromoConfig.PHONE}",
                style = TextStyle(color = c.textPrimary, fontSize = 18.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center),
            )
            Box(
                Modifier
                    .padding(top = 10.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(c.primary)
                    .clickable(onClick = onContinue)
                    .padding(horizontal = 28.dp, vertical = 14.dp),
            ) {
                BasicText("Продолжить", style = TextStyle(color = c.onPrimary, fontSize = 17.sp, fontWeight = FontWeight.SemiBold))
            }
        }
    }
}
