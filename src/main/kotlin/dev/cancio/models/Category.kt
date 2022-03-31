package dev.cancio.models
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val name: String,
    val content: List<News>
)

val newsStorage =  mutableListOf<Category>(
    Category(
        name = "Jogatina",
        content = mutableListOf<News>(
            News(
                id = "1",
                date = "15/10/2019",
                title = "Stadia, serviço de games na nuvem do Google, será lançado em 19 de Novembro",
                urlName = "https://g1.globo.com/pop-arte/games/noticia/2019/10/15/stadia-servico-de-games-na-nuvem-do-google-sera-lancado-em-19-de-novembro.ghtml"
            ),
            News(
                id = "2",
                date = "26/04/2019",
                title = "Mortal Kombat: Como fazer todos os fatalities?",
                urlName = "https://www.uol.com.br/start/ultimas-noticias/2019/04/26/mortal-kombat-11-como-fazer-todas-as-fatalities.htm"
            ),
            News(
                id = "3",
                date = "21/10/2016",
                title = "Conheça 5 distribuições GNU/Linux voltadas para jogos",
                urlName = "https://sempreupdate.com.br/conheca-5-distribuicoes-gnu-linux-voltadas-para-jogos/"
            )
        )
    ),
    Category(
        name = "sistemas_operacionais",
        content = mutableListOf<News>(
            News(
                id = "1",
                date = "22/05/2019",
                title = "Estes são os 12 problemas já encontrados na atualização do Windows 10",
                urlName = "https://olhardigital.com.br/noticia/microsoft-lista-todos-os-problemas-da-nova-atualizacao-do-windows-10/86052"
            ),
            News(
                id = "2",
                date = "10/05/2015",
                title = "Atualização do Windows 10 está causando problemas para alguns usuários\"",
                urlName = "https://canaltech.com.br/windows/atualizacao-do-windows-10-esta-causando-problemas-para-alguns-usuarios-46921/"
            ),
            News(
                id = "3",
                date = "04/05/2016",
                title = "Top 5 distribuições Linux que podem substituir o Windows 10",
                urlName = "https://pplware.sapo.pt/linux/top-5-distribuies-gnulinux-que-podem-substituir-o-windows-10/"
            )
        )
    ),
)