package iut.montpellier.booklibrary.presentation.homeScreen


import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ReportProblem
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import iut.montpellier.booklibrary.presentation.tabScreen.TabScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val urlHandler = LocalUriHandler.current
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(250.dp)
                        .padding(16.dp)
                ) {
                    /*Icon(
                        painter = painterResource(id = R.drawable.menu_drawer),
                        contentDescription = "App Logo",
                        modifier = Modifier.size(100.dp)
                            .align(Alignment.CenterHorizontally)
                    )*/

                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = { Text("Home") },
                        selected = true,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = "version"
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = { Text("Version 1.0") },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "version"
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            Toast.makeText(context, "version 1.0", Toast.LENGTH_SHORT).show()
                        }
                    )
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = { Text("Contact Me") },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Contact Me"
                            )
                        },
                        onClick = {

                            urlHandler.openUri("kurundereKevin@gmail.com")
                        }
                    )
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = { Text("Bug report") },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.ReportProblem,
                                contentDescription = "Report"
                            )
                        },
                        onClick = {

                            urlHandler.openUri("kurundereKevin@gmail.com")
                        }
                    )

                }
            }
        }
    ) {


        Scaffold(modifier = Modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(title = {
                    Row(verticalAlignment = Alignment.CenterVertically){

                        Spacer(modifier = Modifier.width(8.dp))

                        Text (
                             "Book Library",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp
                        )





                    }
                },
                    navigationIcon = {

                        IconButton(onClick = { coroutineScope.launch { drawerState.open() }}) {

                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "open drawer")
                        }
                    },
                    scrollBehavior = scrollBehavior

                    )
            }) { innerpadding ->
            Column(
                modifier = Modifier.padding(innerpadding).fillMaxSize()
            ) {

                TabScreen(navHostController = navHostController)
            }

        }


    }


}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navHostController = navController)
}