package com.example.testingmodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testingmodifier.ui.theme.TestingModifierTheme
import com.example.testingmodifier.ui.theme.fontFamily


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingModifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Header("search")
                    CategoryApp()
                }
            }
        }
    }
}

// Can possibly make it a logo. Find a logo function

@Composable
fun Header( name: String, modifier: Modifier = Modifier){

    Row(

        modifier = Modifier
            // wraps completely around the text
            .wrapContentSize(Alignment.TopCenter, false)
            //fills it to hit the edge of the device
            .fillMaxWidth()
            .height(80.dp)
            .background(color = Color(0xFFBE95C4), shape = RectangleShape)) {

        Image(
            painter = painterResource(id = R.drawable.picture2),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 10.dp)
                .width(200.dp)
                .height(60.dp),

            )

        Surface(
            shape = RectangleShape,
            color = Color.LightGray,
            //shadowElevation = 12.dp,
            modifier = Modifier
                // wraps completely around the text
                .wrapContentSize(Alignment.TopCenter, false)
                //fills it to hit the edge of the device
                .size(width = 520.dp, height = 70.dp)
                .padding(top = 20.dp, bottom = 10.dp, start = 15.dp, end = 6.dp)
            // .fillMaxWidth()
        ){
            Text(
                text = name,
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 8.dp, start = 5.dp)
                //.background(Color(0xFF3ddc84))
            )
        }

        Image(
            painter = painterResource(id = R.drawable.icons8_search_128),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 17.dp)
                .requiredSize(45.dp),
            )

/*
        Surface(
            shape = RectangleShape,
            color = Color(0xFFBE95C4),
            //shadowElevation = 12.dp,
            modifier = Modifier
                // wraps completely around the text
                .wrapContentSize(Alignment.TopCenter, false)
                //fills it to hit the edge of the device
                .size(width = 400.dp, height = 100.dp)
               // .fillMaxWidth()
        ) {
            Text(
                fontFamily = fontFamily,
                text = name,
                /*
                fontSize = 40.sp,
                lineHeight = 200.sp,

                 */
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(30.dp)
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RectangleShape
                    ),
                //.background(Color(0xFF3ddc84))

            )

        }

 */
    }

}

@Composable
fun CategoryApp(){
    CategoryList(categoryList = CategoryData().loadCategories())
}


@Composable
fun CategoryList (categoryList:List<Categories>, modifier: Modifier = Modifier){

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 80.dp )
            //.padding(20.dp)
    ) {
        /*
        for(categoryID : Categories in categoryList) {
           item { CategoryCard(categories = categoryID)}
        }
         */

        items(categoryList) {categories ->
            CategoryCard(categories = categories)
        }
    }



/*
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState(), reverseScrolling = true)
    ) {
        repeat(7) {
            for(categoryID : Categories in categoryList) {
                CategoryCard(categories = categoryID)
            }
        }
    }

 */

}



@Composable
fun CategoryCard(categories: Categories){
    Card(modifier = Modifier.padding(15.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Box(modifier = Modifier) {
            Image(
                painter = painterResource(categories.imagesID),
                //bitmap = ImageBitmap.imageResource(id = categories.imagesID),
                contentDescription = null,
                modifier = Modifier
                    .width(700.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
                alpha = 0.8F
            )

            Text(
                text = LocalContext.current.getString(categories.categoryID),
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 116.sp,
                // color is in hex decimal = 3ddc84
                color = Color.Black,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.Center),



            )


        }



       /*
        Surface(
            shape = RoundedCornerShape(16.dp),
            shadowElevation = 8.dp,
        ) {
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(categories.imagesID),
                    contentDescription = null,
                    modifier = Modifier
                        .width(700.dp)
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop,
                    alpha = 0.8F
                )

                Text(
                    text = LocalContext.current.getString(categories.categoryID),
                    fontSize = 100.sp,
                    lineHeight = 116.sp,
                    // color is in hex decimal = 3ddc84
                    color = Color.Black,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(alignment = Alignment.Center)
                )

            }
        }

        */

        /*
        Column(
           // horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            Surface(
                shape = RoundedCornerShape(16.dp),
                shadowElevation = 8.dp,
            ) {
                FilledTonalButton(
                    shape = RoundedCornerShape(16.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Box(modifier = Modifier) {
                        Image(
                            painter = painterResource(categories.imagesID),
                            contentDescription = null,
                            modifier = Modifier
                                .width(700.dp)
                                .height(200.dp)
                                .clip(RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.Crop,
                            alpha = 0.8F
                        )

                        Text(
                            text = LocalContext.current.getString(categories.categoryID),
                            fontSize = 100.sp,
                            lineHeight = 116.sp,
                            // color is in hex decimal = 3ddc84
                            color = Color.Black,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(alignment = Alignment.Center)
                        )
                    }
                }
            }
        }

         */
    }
}

/*
@Preview
@Composable
private fun CategoryCardPreview(){
    CategoryCard(Categories(R.string.clothing,R.drawable.clothing))
}

 */

/**-----------------------------------------------------------------------------------------------*/

/**
@Composable
fun Clothing( name: String, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(15.dp)) {
        Column(
            //horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.SpaceEvenly,

            //verticalArrangement = Arrangement.spacedBy(4.dp),
            //verticalArrangement = Arrangement.SpaceAround,
            //modifier = modifier

        )
        {
            Surface(
                shape = RoundedCornerShape(16.dp),
                shadowElevation = 8.dp,
            ) {
                FilledTonalButton(shape = RoundedCornerShape(16.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Box(modifier = Modifier) {
                        Image(
                            painter = painterResource(id = R.drawable.clothing),
                            contentDescription = null,
                            modifier = Modifier
                                .width(700.dp)
                                .height(200.dp)
                                .clip(RoundedCornerShape(16.dp)),
                               // .wrapContentSize(Alignment.Center),
                            //.align(alignment = Alignment.Center),
                            contentScale = ContentScale.Crop,
                            alpha = 0.8F
                        )

                        Text(
                            text = name,
                            fontSize = 100.sp,
                            lineHeight = 116.sp,
                            // color is in hex decimal = 3ddc84
                            color = Color.Black,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(alignment = Alignment.Center)
                        )
                    }
                }
            }
            /*
        Card(modifier) {
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.clothing),
                    contentDescription = null,
                    modifier = Modifier
                        .width(600.dp)
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp)),
                       // .align(alignment = Alignment.Center),
                    contentScale = ContentScale.Crop,
                    alpha = 0.8F
                )

                Text(
                    text = name,
                    fontSize = 100.sp,
                    lineHeight = 116.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(alignment = Alignment.Center)
                )
            }
        }

         */
        }
    }

    /*
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Surface(color = Color.LightGray, modifier = Modifier
            .border
                (
                border = BorderStroke(1.dp, Color.Black),
                shape = RectangleShape
            )
            .fillMaxWidth()) {
            Text(
                text = "Hello",
                modifier = modifier
                    .padding(20.dp),
                textAlign = TextAlign.Center
            )

        }
        Text(
            text = "Pricing Pals",
            fontSize = 36.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(200.dp)
                .border(
                    border = BorderStroke(2.dp, Color.Black),
                    shape = RectangleShape
                )
        )
        Text(
            text = "Categories",
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
    }

    Text(
        text = "Hello $name!",
        modifier = modifier
    )

     */
}

@Composable
fun Jewelry( name: String, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(15.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            Surface(
                shape = RoundedCornerShape(16.dp),
                shadowElevation = 8.dp,
            ) {
                FilledTonalButton(shape = RoundedCornerShape(16.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Box(modifier = Modifier) {
                        Image(
                            painter = painterResource(id = R.drawable.jewelry),
                            contentDescription = null,
                            modifier = Modifier
                                .width(700.dp)
                                .height(200.dp)
                                .clip(RoundedCornerShape(16.dp)),
                                //.wrapContentSize(Alignment.Center),
                            //.align(alignment = Alignment.Center),
                            contentScale = ContentScale.Crop,
                            alpha = 0.8F
                        )

                        Text(
                            text = name,
                            fontSize = 100.sp,
                            lineHeight = 116.sp,
                            // color is in hex decimal = 3ddc84
                            color = Color.Black,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(alignment = Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

//try to put all the columns in  a box
@Composable
fun CategoryList (){
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.spacedBy(30.dp),
        //verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(top = 120.dp)
            .padding(20.dp)
            //.verticalScroll(rememberScrollState()),

    ) {
       // item { Header(name = "Pricing Pals")}
        item { Clothing(name = "Clothing") }
        item { Jewelry(name = "Jewelry") }
        item { Clothing(name = "Clothing") }
        item { Jewelry(name = "Jewelry") }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestingModifierTheme {
        Header("Pricing Pals")
        //Clothing("Clothing")
        //Spacer(modifier = Modifier.height(1.dp))
        CategoryList()
    }
}
        */