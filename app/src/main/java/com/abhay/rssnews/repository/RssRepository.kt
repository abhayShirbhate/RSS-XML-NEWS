import com.abhay.rssnews.listeners.RssNewsApiListener

interface RssRepository {
    fun getPuneNews(listener: RssNewsApiListener)
}