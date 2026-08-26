package com.example.enesportfolio.feature.portfolio.presentation.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.enesportfolio.core.designsystem.component.ChipRow
import com.example.enesportfolio.core.designsystem.theme.Palette
import com.example.enesportfolio.core.designsystem.theme.projectCardTheme
import com.example.enesportfolio.core.model.ProjectItem
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.Res
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.garanti_1
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.garanti_2
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.garanti_3
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.garanti_icon
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.fieldflow_activation
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.fieldflow_bio
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.fieldflow_dashboard
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.fieldflow_home
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.fieldflow_map
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.fieldflow_ocr
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.github_profile
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.havas_1
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.havas_2
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.havas_3
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.havas_icon
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.hurriyet_1
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.hurriyet_2
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.hurriyet_3
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.hurriyet_icon
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.ismer_1
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.ismer_2
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.ismer_3
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.ismer_icon
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.kmpnews_android
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.kmpnews_desktop
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.kmpnews_ios
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.kmpnews_web
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.migros_1
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.migros_2
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.migros_3
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.migros_icon
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.portfolio_github
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.renault_1
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.renault_2
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.renault_3
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.renault_icon
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.spotter_home
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.spotter_list
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.spotter_map
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.spotter_nav
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private val FlipSpec = tween<Float>(durationMillis = 640, easing = FastOutSlowInEasing)
private val FlipLiftSpec = tween<Dp>(durationMillis = 640, easing = FastOutSlowInEasing)
private val CardShape = RoundedCornerShape(18.dp)
private val PhoneShape = RoundedCornerShape(14.dp)
private val ShotShape = RoundedCornerShape(12.dp)
private val BackFill = Color(0xFF101014)
private val PreviewHeight = 128.dp
private val ChipRowHeight = 62.dp
private val DescriptionHeight = 44.dp

private data class PersonalProjectGallery(
    val phones: List<DrawableResource> = emptyList(),
    val wides: List<DrawableResource> = emptyList(),
    val icon: DrawableResource? = null,
)

@Composable
internal fun PersonalProjectCard(
    project: ProjectItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val gallery = remember(project.index) { galleryFor(project.index) }
    val theme = projectCardTheme(project.index)
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val flipState = remember { MutableTransitionState(false) }
    flipState.targetState = hovered
    val transition = rememberTransition(flipState, label = "personalProjectFlip")
    val rotation = transition.animateFloat(
        transitionSpec = { FlipSpec },
        label = "flipRotation",
    ) { facingBack -> if (facingBack) 180f else 0f }
    val lift = transition.animateDp(
        transitionSpec = { FlipLiftSpec },
        label = "flipLift",
    ) { facingBack -> if (facingBack) (-8).dp else 0.dp }

    val facingBack = rotation.value > 90f

    Box(
        modifier = modifier
            .hoverable(interactionSource)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
            ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(CardShape)
                .background(if (hovered) theme.surfaceHover else theme.surface)
                .border(
                    width = 1.dp,
                    color = if (hovered) theme.borderHover else theme.border,
                    shape = CardShape,
                )
                .graphicsLayer {
                    rotationY = rotation.value
                    translationY = lift.value.toPx()
                    cameraDistance = 16f * density
                },
        ) {
            PersonalProjectFront(
                project = project,
                gallery = gallery,
                hovered = hovered,
            )
        }
        if (facingBack) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clip(CardShape)
                    .background(BackFill)
                    .border(
                        width = 1.dp,
                        color = theme.borderHover,
                        shape = CardShape,
                    )
                    .graphicsLayer {
                        rotationY = rotation.value - 180f
                        translationY = lift.value.toPx()
                        cameraDistance = 16f * density
                    },
            ) {
                PersonalProjectBack(
                    project = project,
                    gallery = gallery,
                    active = hovered,
                    accent = theme.accent,
                )
            }
        }
    }
}

@Composable
private fun PersonalProjectFront(
    project: ProjectItem,
    gallery: PersonalProjectGallery,
    hovered: Boolean,
) {
    val theme = projectCardTheme(project.index)
    Column {
        FrontPreview(gallery = gallery)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(theme.accent.copy(alpha = if (hovered) 0.92f else 0.72f)),
        )
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)) {
            Text(
                text = project.index,
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 15.sp),
                color = theme.accent,
            )
            Text(
                text = project.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 6.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Box(
                modifier = Modifier
                    .padding(top = 6.dp)
                    .fillMaxWidth()
                    .height(DescriptionHeight)
                    .clipToBounds(),
            ) {
                Text(
                    text = project.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.88f),
                    minLines = 2,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            if (project.tags.isNotEmpty()) {
                ChipRow(
                    chips = project.tags,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .height(ChipRowHeight),
                    chipBackground = theme.chipBackground,
                    chipBorder = theme.chipBorder,
                    chipText = theme.chipText,
                )
            }
            Text(
                text = project.linkLabel,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 13.sp),
                color = theme.link,
                modifier = Modifier.padding(top = 10.dp),
            )
        }
    }
}

@Composable
private fun FrontPreview(gallery: PersonalProjectGallery) {
    val iconShape = RoundedCornerShape(10.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(PreviewHeight)
            .clipToBounds()
            .background(Color(0xFF121116)),
        contentAlignment = Alignment.Center,
    ) {
        when {
            gallery.icon != null && gallery.phones.isNotEmpty() -> {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 14.dp, end = 14.dp, top = 12.dp, bottom = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    gallery.phones.take(2).forEach { shot ->
                        Image(
                            painter = painterResource(shot),
                            contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clip(ShotShape),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.TopCenter,
                        )
                    }
                }
            }
            gallery.phones.isNotEmpty() -> {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.Bottom,
                ) {
                    gallery.phones.take(3).forEach { shot ->
                        PhoneShot(
                            screenshot = shot,
                            modifier = Modifier
                                .fillMaxHeight()
                                .aspectRatio(9f / 19.5f),
                        )
                    }
                }
            }
            gallery.wides.isNotEmpty() -> {
                Image(
                    painter = painterResource(gallery.wides.first()),
                    contentDescription = null,
                    modifier = Modifier
                        .matchParentSize()
                        .padding(horizontal = 14.dp, vertical = 10.dp)
                        .clip(ShotShape),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
            }
        }
        gallery.icon?.let { icon ->
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(10.dp)
                    .size(34.dp)
                    .clip(iconShape)
                    .border(1.dp, Color.White.copy(alpha = 0.22f), iconShape),
            )
        }
    }
}

@Composable
private fun PersonalProjectBack(
    project: ProjectItem,
    gallery: PersonalProjectGallery,
    active: Boolean,
    accent: Color,
) {
    val cycleSize = maxOf(gallery.phones.size, gallery.wides.size, 1)
    var page by remember(project.index) { mutableIntStateOf(0) }
    LaunchedEffect(active, cycleSize, project.index) {
        if (!active || cycleSize <= 1) {
            page = 0
            return@LaunchedEffect
        }
        while (true) {
            delay(2600)
            page = (page + 1) % cycleSize
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            gallery.icon != null && gallery.phones.isNotEmpty() -> {
                StoreGallery(shots = gallery.phones, page = page)
            }
            gallery.phones.isNotEmpty() && gallery.wides.isNotEmpty() -> {
                MixedGallery(gallery = gallery, page = page)
            }
            gallery.wides.isNotEmpty() -> {
                WideGallery(shots = gallery.wides, page = page)
            }
            else -> {
                PhoneFanGallery(shots = gallery.phones, page = page)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color(0xF20B0A0E)),
                    ),
                )
                .padding(start = 18.dp, end = 18.dp, top = 36.dp, bottom = 16.dp),
        ) {
            Column {
                Text(
                    text = project.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Palette.Ink,
                )
                Text(
                    text = project.linkLabel,
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 13.sp),
                    color = accent,
                    modifier = Modifier.padding(top = 4.dp),
                )
            }
        }
    }
}

@Composable
private fun StoreGallery(
    shots: List<DrawableResource>,
    page: Int,
) {
    if (shots.isEmpty()) return
    Image(
        painter = painterResource(shots.atWrapped(page)),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        alignment = Alignment.TopCenter,
    )
}

@Composable
private fun PhoneFanGallery(
    shots: List<DrawableResource>,
    page: Int,
) {
    if (shots.isEmpty()) return
    val left = shots.atWrapped(page)
    val center = shots.atWrapped(page + 1)
    val right = shots.atWrapped(page + 2)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp, vertical = 18.dp),
        contentAlignment = Alignment.Center,
    ) {
        PhoneShot(
            screenshot = left,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxHeight(0.82f)
                .aspectRatio(9f / 19.5f)
                .graphicsLayer { rotationZ = -11f; translationY = 10.dp.toPx() },
        )
        PhoneShot(
            screenshot = right,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight(0.82f)
                .aspectRatio(9f / 19.5f)
                .graphicsLayer { rotationZ = 11f; translationY = 10.dp.toPx() },
        )
        PhoneShot(
            screenshot = center,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.92f)
                .aspectRatio(9f / 19.5f),
        )
    }
}

@Composable
private fun MixedGallery(
    gallery: PersonalProjectGallery,
    page: Int,
) {
    val wide = gallery.wides.atWrapped(page)
    val leftPhone = gallery.phones.atWrapped(page)
    val rightPhone = gallery.phones.atWrapped(page + 1)
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(wide),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x990B0A0E)),
        )
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 12.dp, bottom = 44.dp)
                .fillMaxHeight(0.78f),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PhoneShot(
                screenshot = leftPhone,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(9f / 19.5f)
                    .graphicsLayer { rotationZ = -6f },
            )
            PhoneShot(
                screenshot = rightPhone,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(9f / 19.5f)
                    .graphicsLayer { rotationZ = 6f },
            )
        }
    }
}

@Composable
private fun WideGallery(
    shots: List<DrawableResource>,
    page: Int,
) {
    if (shots.isEmpty()) return
    val back = shots.atWrapped(page)
    val front = shots.atWrapped(page + 1)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp, vertical = 20.dp),
    ) {
        WindowShot(
            screenshot = back,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(0.94f)
                .fillMaxHeight(0.62f)
                .graphicsLayer { rotationZ = -3.5f; translationY = 4.dp.toPx() },
        )
        WindowShot(
            screenshot = front,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(0.94f)
                .fillMaxHeight(0.62f)
                .offset(y = (-22).dp)
                .graphicsLayer { rotationZ = 2.8f },
        )
    }
}

@Composable
private fun PhoneShot(
    screenshot: DrawableResource,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(PhoneShape)
            .background(Color(0xFF1A191F))
            .border(1.dp, Color.White.copy(alpha = 0.18f), PhoneShape)
            .padding(3.dp)
            .clip(RoundedCornerShape(12.dp)),
    ) {
        Image(
            painter = painterResource(screenshot),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
        )
    }
}

@Composable
private fun WindowShot(
    screenshot: DrawableResource,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(ShotShape)
            .background(Color(0xFF1A191F))
            .border(1.dp, Color.White.copy(alpha = 0.16f), ShotShape),
    ) {
        Image(
            painter = painterResource(screenshot),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
        )
    }
}

private fun galleryFor(index: String): PersonalProjectGallery = when (index) {
    "01" -> PersonalProjectGallery(
        phones = listOf(Res.drawable.garanti_1, Res.drawable.garanti_2, Res.drawable.garanti_3),
        icon = Res.drawable.garanti_icon,
    )
    "02" -> PersonalProjectGallery(
        phones = listOf(Res.drawable.migros_1, Res.drawable.migros_2, Res.drawable.migros_3),
        icon = Res.drawable.migros_icon,
    )
    "03" -> PersonalProjectGallery(
        phones = listOf(Res.drawable.hurriyet_1, Res.drawable.hurriyet_2, Res.drawable.hurriyet_3),
        icon = Res.drawable.hurriyet_icon,
    )
    "04" -> PersonalProjectGallery(
        phones = listOf(Res.drawable.havas_1, Res.drawable.havas_2, Res.drawable.havas_3),
        icon = Res.drawable.havas_icon,
    )
    "05" -> PersonalProjectGallery(
        phones = listOf(Res.drawable.renault_1, Res.drawable.renault_2, Res.drawable.renault_3),
        icon = Res.drawable.renault_icon,
    )
    "06" -> PersonalProjectGallery(
        phones = listOf(Res.drawable.ismer_1, Res.drawable.ismer_2, Res.drawable.ismer_3),
        icon = Res.drawable.ismer_icon,
    )
    "07" -> PersonalProjectGallery(
        phones = listOf(
            Res.drawable.spotter_home,
            Res.drawable.spotter_list,
            Res.drawable.spotter_map,
            Res.drawable.spotter_nav,
        ),
    )
    "08" -> PersonalProjectGallery(
        phones = listOf(Res.drawable.kmpnews_ios, Res.drawable.kmpnews_android),
        wides = listOf(Res.drawable.kmpnews_web, Res.drawable.kmpnews_desktop),
    )
    "09" -> PersonalProjectGallery(
        phones = listOf(
            Res.drawable.fieldflow_dashboard,
            Res.drawable.fieldflow_activation,
            Res.drawable.fieldflow_bio,
            Res.drawable.fieldflow_home,
            Res.drawable.fieldflow_map,
            Res.drawable.fieldflow_ocr,
        ),
    )
    "10" -> PersonalProjectGallery(
        wides = listOf(Res.drawable.portfolio_github, Res.drawable.github_profile),
    )
    else -> PersonalProjectGallery()
}

private fun <T> List<T>.atWrapped(index: Int): T {
    val size = this.size
    if (size == 0) error("empty gallery")
    return this[(index % size + size) % size]
}
