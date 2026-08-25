package com.example.enesportfolio.feature.portfolio.presentation.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.enesportfolio.core.designsystem.component.ChipRow
import com.example.enesportfolio.core.designsystem.component.LanguageToggle
import com.example.enesportfolio.core.designsystem.component.OverlineText
import com.example.enesportfolio.core.designsystem.component.PortfolioCard
import com.example.enesportfolio.core.designsystem.component.SectionTitle
import com.example.enesportfolio.core.designsystem.component.SocialIcons
import com.example.enesportfolio.core.designsystem.component.SocialLinkChip
import com.example.enesportfolio.core.designsystem.component.StatusDot
import com.example.enesportfolio.core.designsystem.theme.Palette
import com.example.enesportfolio.core.designsystem.theme.PortfolioFonts
import com.example.enesportfolio.core.model.AppLanguage
import com.example.enesportfolio.core.model.Links
import com.example.enesportfolio.core.model.NoteItem
import com.example.enesportfolio.core.model.PortfolioContent
import com.example.enesportfolio.core.model.PortfolioCopy
import com.example.enesportfolio.core.model.ProjectItem
import com.example.enesportfolio.core.model.SkillGroup
import com.example.enesportfolio.feature.portfolio.contract.PortfolioContract
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.Res
import com.example.enesportfolio.feature.portfolio.presentation.generated.resources.avatar
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

private enum class PortfolioSection {
    Top,
    Experience,
    Work,
    Notes,
}

private val PageMaxWidth = 1120.dp

@Composable
internal fun PortfolioScreenContent(
    uiState: PortfolioContract.UiState,
    onAction: (PortfolioContract.Action) -> Unit,
) {
    val content = uiState.content ?: return
    val copy = content.copy
    val languageCode = uiState.language.code
    val uriHandler = LocalUriHandler.current
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val sectionIndices = remember {
        mapOf(
            PortfolioSection.Top to 0,
            PortfolioSection.Experience to 3,
            PortfolioSection.Work to 4,
            PortfolioSection.Notes to 5,
        )
    }

    Box(modifier = Modifier.fillMaxSize().background(Palette.Background)) {
        AtmosphereBackground()

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 64.dp),
        ) {
            item(key = "nav") {
                PageWidth {
                    TopNav(
                        copy = copy,
                        selectedLanguage = languageCode,
                        onLanguageSelected = { code ->
                            onAction(PortfolioContract.Action.LanguageSelected(AppLanguage.fromCode(code)))
                        },
                        onNavigate = { section ->
                            sectionIndices[section]?.let { index ->
                                scope.launch { listState.animateScrollToItem(index) }
                            }
                        },
                    )
                }
            }
            item(key = "hero") {
                ScrollRevealItem(listState = listState, itemIndex = 1) {
                    PageWidth {
                    HeroSection(
                        copy = copy,
                        languageCode = languageCode,
                        onOpenLink = uriHandler::openUri,
                        onDownloadCv = { onAction(PortfolioContract.Action.DownloadCv) },
                    )
                    }
                }
            }
            item(key = "intro") {
                ScrollRevealItem(listState = listState, itemIndex = 2) {
                    PageWidth { IntroSection(copy = copy, languageCode = languageCode) }
                }
            }
            item(key = "experience") {
                ScrollRevealItem(listState = listState, itemIndex = 3) {
                    PageWidth { ExperienceSection(content = content, languageCode = languageCode) }
                }
            }
            item(key = "work") {
                ScrollRevealItem(listState = listState, itemIndex = 4) {
                    PageWidth {
                        WorkSection(
                            content = content,
                            languageCode = languageCode,
                            onOpenLink = uriHandler::openUri,
                        )
                    }
                }
            }
            item(key = "notes") {
                ScrollRevealItem(listState = listState, itemIndex = 5) {
                    PageWidth {
                        NotesSection(
                            copy = copy,
                            notes = content.notes,
                            languageCode = languageCode,
                            onOpenLink = uriHandler::openUri,
                        )
                    }
                }
            }
            item(key = "footer") {
                ScrollRevealItem(listState = listState, itemIndex = 6) {
                    PageWidth { FooterSection(copy = copy, onOpenLink = uriHandler::openUri) }
                }
            }
        }
    }
}

@Composable
private fun PageWidth(
    content: @Composable () -> Unit,
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter,
    ) {
        val horizontalPadding = if (maxWidth < 560.dp) 22.dp else 19.dp
        Box(
            modifier = Modifier
                .widthIn(max = PageMaxWidth)
                .padding(horizontal = horizontalPadding),
        ) {
            content()
        }
    }
}

@Composable
private fun AtmosphereBackground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Palette.Violet.copy(alpha = 0.28f), Color.Transparent),
                center = Offset(size.width * 0.06f, size.height * -0.12f),
                radius = size.width * 0.8f,
            ),
            radius = size.width * 0.8f,
            center = Offset(size.width * 0.06f, size.height * -0.12f),
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Palette.Gold.copy(alpha = 0.14f), Color.Transparent),
                center = Offset(size.width, size.height * 0.08f),
                radius = size.width * 0.52f,
            ),
            radius = size.width * 0.52f,
            center = Offset(size.width, size.height * 0.08f),
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Palette.Mint.copy(alpha = 0.12f), Color.Transparent),
                center = Offset(size.width * 0.72f, size.height * 1.08f),
                radius = size.width * 0.56f,
            ),
            radius = size.width * 0.56f,
            center = Offset(size.width * 0.72f, size.height * 1.08f),
        )
    }
}

@Composable
private fun TopNav(
    copy: PortfolioCopy,
    selectedLanguage: String,
    onLanguageSelected: (String) -> Unit,
    onNavigate: (PortfolioSection) -> Unit,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 22.dp, bottom = 6.dp),
    ) {
        val stacked = maxWidth < 860.dp
        if (stacked) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    LanguageToggle(
                        selected = selectedLanguage,
                        onLanguageSelected = onLanguageSelected,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                    horizontalArrangement = Arrangement.spacedBy(18.dp),
                ) {
                    NavLink(copy.navExperience) { onNavigate(PortfolioSection.Experience) }
                    NavLink(copy.navWork) { onNavigate(PortfolioSection.Work) }
                    NavLink(copy.navNotes) { onNavigate(PortfolioSection.Notes) }
                }
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                    NavLink(copy.navExperience) { onNavigate(PortfolioSection.Experience) }
                    NavLink(copy.navWork) { onNavigate(PortfolioSection.Work) }
                    NavLink(copy.navNotes) { onNavigate(PortfolioSection.Notes) }
                }
                Spacer(modifier = Modifier.weight(1f))
                LanguageToggle(
                    selected = selectedLanguage,
                    onLanguageSelected = onLanguageSelected,
                )
            }
        }
    }
}

@Composable
private fun NavLink(
    label: String,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    Text(
        text = label,
        modifier = Modifier
            .hoverable(interactionSource)
            .clickable(onClick = onClick),
        style = MaterialTheme.typography.bodySmall,
        color = if (hovered) Palette.Ink else Palette.Muted,
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun HeroSection(
    copy: PortfolioCopy,
    languageCode: String,
    onOpenLink: (String) -> Unit,
    onDownloadCv: () -> Unit,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp, bottom = 32.dp),
    ) {
        val stacked = maxWidth < 860.dp
        val compactHero = maxWidth < 560.dp
        val portraitWidth = if (stacked) minOf(maxWidth * 0.54f, 200.dp) else minOf(maxWidth * 0.72f, 320.dp)
        if (stacked) {
            Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                PortraitBlock(copy.portraitCaption, width = portraitWidth)
                HeroCopy(copy = copy, languageCode = languageCode, onOpenLink = onOpenLink, onDownloadCv = onDownloadCv, compact = compactHero)
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                HeroCopy(
                    copy = copy,
                    languageCode = languageCode,
                    onOpenLink = onOpenLink,
                    onDownloadCv = onDownloadCv,
                    modifier = Modifier.weight(1.2f),
                )
                PortraitBlock(
                    caption = copy.portraitCaption,
                    width = portraitWidth,
                    modifier = Modifier.weight(0.72f),
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun HeroCopy(
    copy: PortfolioCopy,
    languageCode: String,
    onOpenLink: (String) -> Unit,
    onDownloadCv: () -> Unit,
    modifier: Modifier = Modifier,
    compact: Boolean = false,
) {
    BoxWithConstraints(modifier = modifier) {
        val titleSize = if (compact) {
            (maxWidth.value * 0.14f).coerceIn(43f, 64f).sp
        } else {
            (maxWidth.value * 0.084f).coerceIn(51f, 102f).sp
        }
        val roleSize = (maxWidth.value * 0.02f).coerceIn(17f, 20.5f).sp
        val serif = PortfolioFonts.serifFamily
        val sans = PortfolioFonts.sansFamily

        Column {
            OverlineText(copy.heroOverline, languageCode = languageCode)
            Text(
                text = "Enes Selçuk",
                style = TextStyle(
                    fontFamily = serif,
                    fontWeight = FontWeight.Medium,
                    fontSize = titleSize,
                    lineHeight = titleSize * 0.92f,
                    letterSpacing = titleSize * -0.045f,
                    color = Palette.Ink,
                ),
                modifier = Modifier.padding(top = 7.dp),
            )
            Text(
                text = copy.heroRole,
                style = TextStyle(
                    fontFamily = sans,
                    fontWeight = FontWeight.Medium,
                    fontSize = roleSize,
                    lineHeight = roleSize * 1.2f,
                    color = Palette.Mint,
                ),
                modifier = Modifier.padding(top = 17.dp),
            )
            Text(
                text = copy.heroLede,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 14.dp).widthIn(max = 608.dp),
            )
            FlowRow(
                modifier = Modifier.padding(top = 26.dp),
                horizontalArrangement = Arrangement.spacedBy(9.dp),
                verticalArrangement = Arrangement.spacedBy(9.dp),
            ) {
                SocialLinkChip("LinkedIn", SocialIcons.LinkedIn, onClick = { onOpenLink(Links.LinkedIn) })
                SocialLinkChip("GitHub", SocialIcons.GitHub, onClick = { onOpenLink(Links.GitHub) })
                SocialLinkChip("Medium", SocialIcons.Medium, onClick = { onOpenLink(Links.Medium) })
                SocialLinkChip("Email", SocialIcons.Email, onClick = { onOpenLink(Links.Email) })
                SocialLinkChip(copy.downloadCv, SocialIcons.Cv, onClick = onDownloadCv)
            }
        }
    }
}

@Composable
private fun PortraitBlock(
    caption: String,
    width: Dp,
    modifier: Modifier = Modifier,
) {
    val shape = portraitShape(width)
    Column(
        modifier = modifier.width(width),
        horizontalAlignment = Alignment.Start,
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .offset(x = 18.dp, y = 22.dp)
                    .clip(shape)
                    .background(Palette.GoldGlow),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(shape)
                    .background(Palette.VioletGlow)
                    .padding(8.dp),
            ) {
                Image(
                    painter = painterResource(Res.drawable.avatar),
                    contentDescription = "Portrait of Enes Selçuk",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape)
                        .border(1.dp, Palette.Line, shape),
                    contentScale = ContentScale.Crop,
                )
            }
        }
        Row(
            modifier = Modifier.padding(top = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            StatusDot()
            Text(
                text = caption,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 13.8.sp),
                color = Palette.Muted,
            )
        }
    }
}

private fun portraitShape(size: Dp) = RoundedCornerShape(
    topStart = size * 0.28f,
    topEnd = size * 0.12f,
    bottomEnd = size * 0.32f,
    bottomStart = size * 0.16f,
)

@Composable
private fun IntroSection(copy: PortfolioCopy, languageCode: String) {
    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        val stacked = maxWidth < 860.dp
        if (stacked) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                AboutCard(copy)
                NowCard(copy, languageCode = languageCode)
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                AboutCard(copy, modifier = Modifier.weight(1.35f))
                NowCard(copy, languageCode = languageCode, modifier = Modifier.weight(0.8f))
            }
        }
    }
}

@Composable
private fun AboutCard(copy: PortfolioCopy, modifier: Modifier = Modifier) {
    PortfolioCard(modifier = modifier) {
        SectionTitle(copy.aboutTitle)
        Text(
            text = copy.aboutBody,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 12.dp),
        )
    }
}

@Composable
private fun NowCard(
    copy: PortfolioCopy,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    PortfolioCard(
        modifier = modifier,
        shape = RoundedCornerShape(32.dp),
        backgroundColor = Palette.BackgroundElevated,
    ) {
        Box {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Palette.Violet.copy(alpha = 0.08f), Color.Transparent),
                            startY = 0f,
                            endY = 280f,
                        ),
                    ),
            )
            Column {
                OverlineText(copy.nowLabel, languageCode = languageCode)
                listOf(copy.nowOne, copy.nowTwo, copy.nowThree).forEach { item ->
                    Row(
                        modifier = Modifier.padding(top = 14.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .width(2.dp)
                                .height(20.dp)
                                .background(Palette.Violet),
                        )
                        Text(
                            text = item,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Normal,
                                color = Palette.Ink,
                            ),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ExperienceSection(content: PortfolioContent, languageCode: String) {
    val copy = content.copy
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
    ) {
        val stacked = maxWidth < 860.dp
        if (stacked) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                ExperienceTimeline(copy, languageCode = languageCode)
                SideColumn(copy = copy, skillGroups = content.skillGroups, languageCode = languageCode)
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                ExperienceTimeline(copy, languageCode = languageCode, modifier = Modifier.weight(1.2f))
                SideColumn(
                    copy = copy,
                    skillGroups = content.skillGroups,
                    languageCode = languageCode,
                    modifier = Modifier.weight(0.85f),
                )
            }
        }
    }
}

@Composable
private fun ExperienceTimeline(
    copy: PortfolioCopy,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    PortfolioCard(modifier = modifier) {
        OverlineText(copy.expOverline, languageCode = languageCode)
        SectionTitle(copy.expTitle, modifier = Modifier.padding(top = 6.dp))
        TimelineEntry(
            copy.j1When,
            "Eteration Bilişim A.Ş.",
            copy.j1Role,
            listOf(copy.j1a, copy.j1b, copy.j1c, copy.j1d, copy.j1e, copy.j1f),
        )
        TimelineEntry(copy.j2When, "Nuevo Softwarehouse", copy.j2Role, listOf(copy.j2a, copy.j2b, copy.j2c))
        TimelineEntry(copy.j3When, copy.j3Company, copy.j3Role, listOf(copy.j3a))
    }
}

@Composable
private fun TimelineEntry(
    whenText: String,
    company: String,
    role: String,
    highlights: List<String>,
) {
    Column(
        modifier = Modifier
            .padding(top = 25.dp)
            .padding(start = 18.dp)
            .drawBehind {
                drawLine(
                    color = Palette.Line,
                    start = Offset(0f, 0f),
                    end = Offset(0f, size.height),
                    strokeWidth = 1.dp.toPx(),
                )
            },
    ) {
        Text(text = whenText, style = MaterialTheme.typography.labelMedium, color = Palette.Violet)
        Text(
            text = company,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 3.dp),
        )
        Text(
            text = role,
            style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.7.sp),
            modifier = Modifier.padding(top = 2.dp),
        )
        highlights.forEach { highlight ->
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
                    .padding(start = 14.dp)
                    .drawBehind {
                        drawLine(
                            color = Palette.Violet.copy(alpha = 0.45f),
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 2.dp.toPx(),
                        )
                    },
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    text = highlight,
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.7.sp),
                    modifier = Modifier.padding(start = 10.dp),
                )
            }
        }
    }
}

@Composable
private fun SideColumn(
    copy: PortfolioCopy,
    skillGroups: List<SkillGroup>,
    languageCode: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        PortfolioCard {
            OverlineText(copy.stackOverline, languageCode = languageCode)
            SectionTitle(copy.stackTitle, modifier = Modifier.padding(top = 6.dp))
            skillGroups.forEach { group ->
                Text(
                    text = group.title.asOverline(languageCode),
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 12.sp,
                        letterSpacing = 1.44.sp,
                        color = Palette.Muted,
                    ),
                    modifier = Modifier.padding(top = 18.dp, bottom = 7.dp),
                )
                ChipRow(chips = group.skills)
            }
        }
        PortfolioCard {
            OverlineText(copy.eduOverline, languageCode = languageCode)
            Text(
                text = copy.eduUniversity,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 6.dp),
            )
            Text(text = copy.eduDegree, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(top = 5.dp))
            Text(text = copy.eduWhen, style = MaterialTheme.typography.labelMedium, modifier = Modifier.padding(top = 9.dp))
        }
    }
}

private fun String.asOverline(languageCode: String): String =
    when (languageCode.lowercase()) {
        "tr" -> replace('i', 'İ').replace('ı', 'I').uppercase()
        else -> uppercase()
    }

@Composable
private fun WorkSection(
    content: PortfolioContent,
    languageCode: String,
    onOpenLink: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 38.dp),
    ) {
        OverlineText(content.copy.prodOverline, languageCode = languageCode)
        SectionTitle(content.copy.prodTitle, modifier = Modifier.padding(top = 5.dp, bottom = 16.dp))
        ProjectGrid(content.productionProjects, onOpenLink)
        OverlineText(content.copy.persOverline, languageCode = languageCode, modifier = Modifier.padding(top = 32.dp))
        SectionTitle(content.copy.persTitle, modifier = Modifier.padding(top = 5.dp, bottom = 16.dp))
        ProjectGrid(content.personalProjects, onOpenLink, columns = 2)
    }
}

@Composable
private fun ProjectGrid(
    projects: List<ProjectItem>,
    onOpenLink: (String) -> Unit,
    columns: Int = 3,
) {
    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        val stacked = maxWidth < 860.dp
        val columnCount = if (stacked) 1 else columns
        val rows = projects.chunked(columnCount)
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            rows.forEach { rowProjects ->
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    rowProjects.forEach { project ->
                        ProjectCard(
                            project = project,
                            onClick = { onOpenLink(project.url) },
                            modifier = Modifier.weight(1f),
                        )
                    }
                    repeat(columnCount - rowProjects.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
private fun ProjectCard(
    project: ProjectItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val lift by animateDpAsState(
        targetValue = if (hovered) (-4).dp else 0.dp,
        animationSpec = tween(durationMillis = 250),
        label = "projectLift",
    )
    PortfolioCard(
        modifier = modifier
            .offset(y = lift)
            .hoverable(interactionSource)
            .clickable(onClick = onClick),
        backgroundColor = if (hovered) Palette.BackgroundElevated2 else Palette.BackgroundElevated,
        borderColor = if (hovered) Palette.Violet.copy(alpha = 0.4f) else Palette.Line,
    ) {
        Text(
            text = project.index,
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 18.4.sp),
            color = Palette.Gold,
        )
        Text(
            text = project.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 11.dp),
        )
        Text(
            text = project.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp),
        )
        Text(
            text = project.linkLabel,
            style = MaterialTheme.typography.bodySmall.copy(fontSize = 13.8.sp),
            color = Palette.Mint,
            modifier = Modifier.padding(top = 18.dp),
        )
    }
}

@Composable
private fun NotesSection(
    copy: PortfolioCopy,
    notes: List<NoteItem>,
    languageCode: String,
    onOpenLink: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 38.dp),
    ) {
        PortfolioCard(
            contentPadding = PaddingValues(horizontal = 22.dp, vertical = 24.dp),
        ) {
            OverlineText(copy.notesOverline, languageCode = languageCode)
            SectionTitle(copy.notesTitle, modifier = Modifier.padding(top = 5.dp, bottom = 8.dp))
            notes.forEachIndexed { index, note ->
                NoteRow(
                    note = note,
                    stacked = false,
                    showBottomBorder = index < notes.lastIndex,
                    onClick = { onOpenLink(note.url) },
                )
            }
        }
    }
}

@Composable
private fun NoteRow(
    note: NoteItem,
    stacked: Boolean,
    showBottomBorder: Boolean,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .hoverable(interactionSource)
            .clickable(onClick = onClick)
            .drawBehind {
                if (showBottomBorder) {
                    drawLine(
                        color = Palette.Line,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = 1.dp.toPx(),
                    )
                }
            }
            .padding(vertical = 15.dp, horizontal = 3.dp),
    ) {
        val narrow = maxWidth < 560.dp || stacked
        if (narrow) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = note.whenLabel,
                    style = MaterialTheme.typography.labelMedium,
                    color = if (hovered) Palette.Violet else Palette.Violet,
                )
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.bodyMedium.copy(color = if (hovered) Palette.Violet else Palette.Ink),
                )
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(13.dp)) {
                Text(
                    text = note.whenLabel,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.width(72.dp),
                    color = Palette.Violet,
                )
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.bodyMedium.copy(color = if (hovered) Palette.Violet else Palette.Ink),
                )
            }
        }
    }
}

@Composable
private fun FooterSection(
    copy: PortfolioCopy,
    onOpenLink: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 56.dp, bottom = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {
        Text(
            text = copy.footerFocus,
            style = MaterialTheme.typography.bodyMedium,
            color = Palette.Muted,
        )
        Text(
            text = "© Copyright 2026. Made by enesselcukk",
            style = MaterialTheme.typography.labelSmall,
        )
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            FooterLink("GitHub") { onOpenLink(Links.GitHub) }
            FooterLink("LinkedIn") { onOpenLink(Links.LinkedIn) }
        }
    }
}

@Composable
private fun FooterLink(
    label: String,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    Text(
        text = label,
        modifier = Modifier
            .hoverable(interactionSource)
            .clickable(onClick = onClick),
        style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.7.sp),
        color = if (hovered) Palette.Ink else Palette.Mint,
    )
}
