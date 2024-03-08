import com.abhay.rssnews.retrofit_client.RSSService
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://timesofindia.indiatimes.com/"
    private var retrofit: Retrofit? = null
    private val client: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    val rssService: RSSService = client.create(RSSService::class.java)
}
