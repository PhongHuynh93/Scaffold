@file:OptIn(ExperimentalFoundationApi::class)

package com.wind.scaffold.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wind.scaffold.ui.theme.ScaffoldTheme

val movieTitles = listOf(
    "The Shawshank Redemption",
    "The Godfather",
    "The Dark Knight",
    "12 Angry Men",
    "Schindler's List",
    "The Lord of the Rings: The Return of the King",
    "Pulp Fiction",
    "Forrest Gump",
    "Inception",
    "The Lord of the Rings: The Fellowship of the Ring"
)

@Composable
fun VerticalMovieList(movieTitles: List<String>) {
    LazyColumn {
        items(movieTitles) { movieTitle ->
            // This block of code will be called for each item in the movieTitles list
            Text(text = movieTitle)
        }
    }
}

@Composable
fun HorizontalMovieList(movieTitles: List<String>) {
    LazyRow {
        items(movieTitles) { movieTitle ->
            // This block of code will be called for each item in the movieTitles list
            Text(text = movieTitle)
        }
    }
}

data class Movie(val title: String, val description: String)

val movies = listOf(
    Movie(
        "Inception",
        "A thief who steals corporate secrets through the use of dream-sharing technology."
    ),
    Movie(
        "The Dark Knight",
        "Batman sets out to dismantle the remaining criminal organizations that plague the streets."
    ),
    Movie(
        "Interstellar",
        "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."
    )
)

@Composable
fun MovieList(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie = movie)
        }
        item {
            Text(
                text = "That's all for now!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = movie.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = movie.description,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun ItemIndexedMovieList(movies: List<Movie>) {
    LazyColumn {
        itemsIndexed(movies) { index, movie ->
            ItemIndexedMovieItem(index, movie)
        }
    }
}

@Composable
fun ItemIndexedMovieItem(index: Int, movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Movie ${index + 1}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = movie.title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = movie.description, color = Color.Gray)
        }
    }
}

val movies2 = listOf(
    Movie(
        "The Godfather",
        "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."
    ),
    Movie(
        "The Shawshank Redemption",
        "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."
    ),
    Movie(
        "The Dark Knight",
        "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."
    ),
    Movie(
        "The Godfather: Part II",
        "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate."
    ),
    Movie(
        "12 Angry Men",
        "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence."
    ),
    Movie(
        "Schindler's List",
        "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis."
    ),
    Movie(
        "The Lord of the Rings: The Return of the King",
        "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring."
    ),
    Movie(
        "Pulp Fiction",
        "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption."
    )
)

val groupedMovies = movies2.groupBy { it.title.first().toUpperCase() }

@Composable
fun GroupedMovieList(movies2: List<Movie>) {
    LazyColumn {
        groupedMovies.forEach { (groupKey, groupMovies) ->
            stickyHeader {
                Text(
                    text = groupKey.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .padding(16.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            items(groupMovies) { movie ->
                Text(
                    text = movie.title,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
data class Message(val sender: String, val message: String, val time: String)

val chatData = listOf(
    Message("Alice", "Hi Bob, how are you?", "10:05 AM"),
    Message("Bob", "I'm good, thanks for asking. How about you?", "10:08 AM"),
    Message("Alice", "I'm doing well too. Did you finish that project we talked about?", "10:10 AM"),
    Message("Bob", "Yes, I did! It took longer than expected, but it turned out great.", "10:15 AM"),
    Message("Alice", "Awesome! Can't wait to see it.", "10:17 AM"),
    Message("Bob", "Sure thing, I'll send it to you once I get back to my desk.", "10:20 AM")
)

@Composable
fun ChatScreen(messages: List<Message>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        items(messages) { message ->
            ChatBubble(
                message = message,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ChatBubble(message: Message, modifier: Modifier = Modifier) {
    Row(modifier) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = message.sender, fontWeight = FontWeight.Bold)
            Text(text = message.message)
        }
        Text(text = message.time, modifier = Modifier.padding(start = 8.dp))
    }
}

@Composable
fun ChatPagingList(movies: List<Message>) {

    val listState = rememberLazyListState()

    val shouldLoadMore by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex >= movies.lastIndex - 5
        }
    }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        items(movies) { message ->
            ChatBubble(
                message = message,
                modifier = Modifier.fillMaxWidth()
            )
            if (shouldLoadMore) {
                // TODO loadNextPage()
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun BasicLazyColumnPreview() {
    ScaffoldTheme {
        VerticalMovieList(movieTitles)
    }
}

@Preview(showBackground = true)
@Composable
fun BasicLazyRowPreview() {
    ScaffoldTheme {
        HorizontalMovieList(movieTitles)
    }
}

@Preview(showBackground = true)
@Composable
fun MoviePreview() {
    ScaffoldTheme {
        MovieList(movies)
    }
}

@Preview(showBackground = true)
@Composable
fun ItemIndexedMoviePreview() {
    ScaffoldTheme {
        ItemIndexedMovieList(movies)
    }
}

@Preview(showBackground = true)
@Composable
fun StickyHeaderMoviePreview() {
    ScaffoldTheme {
        GroupedMovieList(movies2)
    }
}

@Preview(showBackground = true)
@Composable
fun ChatPreview() {
    ScaffoldTheme {
        ChatScreen(chatData)
    }
}

@Preview(showBackground = true)
@Composable
fun ChatPagingPreview() {
    ScaffoldTheme {
        ChatPagingList(chatData)
    }
}
