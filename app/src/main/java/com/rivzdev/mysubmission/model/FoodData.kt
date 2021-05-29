package com.rivzdev.mysubmission.model

import com.rivzdev.mysubmission.R

object FoodData {

    private val foodNames = arrayOf(
        "Karedok",
        "Lotek",
        "Bakakak Hayam",
        "Empal Gepuk Daging Sapi",
        "Mi Kocok",
        "Sate Maranggi",
        "Empal Gentong",
        "Awug",
        "Nasi Timbel",
        "Nasi Tutug Oncom"
    )

    private val foodDetails = arrayOf(
        "Karedok adalah makanan khas Sunda yang sekilas mirip dengan gado-gado. Banyak yang mengira karedok berasal dari Jakarta, padahal karedok adalah makanan asli Sunda yang memang banyak ditemukan di berbagai daerah di Indonesia. Karedok menyajikan berbagai sayuran dengan saus kacang tanah dengan kepedasan yang bisa menggugah selera. Karedok ini disajikan dari sayuran yang mentah dan tidak diolah yang sehat untuk disantap, khususnya untuk Anda yang ingin menjalankan program diet. Karedok memiliki yang rasa unik karena perpaduan dari kencur dan saus kacang yang menjadi satu. Sayur-sayuran yang digunakan untuk membuat karedok cukup beragam, seperti timun, tauge, kacang-kacangan, terong hijau kecil, kubis, basil, dan beberapa jenis sayuran lagi yang bisa ditambahkan sesuai selera pembuatnya. Ada perbedaan antara gado-gado dengan karedok. Kalau gado-gado menggunakan sayuran yang sudah direbus, karedok memakai sayuran yang masih mentah. Di Sunda, orang juga menyebut karedok dengan nama lotek atah yang berarti lotek mentah. Karedok paling enak disantap bersama nasi panas, tempe, tahu, dan kerupuk.",
        "Lotek sendiri menggunakan sayur mayur yang tak jauh berbeda dengan gado-gado, seperti kangkung, kembang kol, dan tauge. Namun, ada beberapa sayur yang wajib ada dalam lotek, seperti bayam, kacang panjang, kapri, dan daun kacang kedelai. Sayur mayur yang telah dicacah akan disiram dengan bumbu kacang yang ditambahkan dengan kentang rebus yang sudah ditumbuk dan kencur sehingga membuat rasanya menjadi lebih unik. Lotek biasanya dihidangkan bersama potongan lontong dan menu pelengkap kerupuk udang.",
        "Bakakak hayam adalah menu masakan unggulan yang mudah dijumpai di tanah Sunda. Sebagai makanan khas Sunda beberapa orang mungkin menganggap nama makanan ini lucu dan unik, terutama untuk mereka yang baru pertama kali mendengarnya. Sebagian besar masyarakat Sunda khususnya daerah Pandeglang, bakakak hayam digolongkan menjadi makanan yang digunakan untuk kegiatan pesta adat, seperti pernikahan, sunatan dan upacara adat lainnya. Bakakak hayam sendiri merupakan masakan yang menggunakan bahan utama berupa ayam yang diberikan bumbu khusus bercita rasa Sunda yang kemudian diolah dengan cara dipanggang. Ayam yang disajikan merupakan satu ekor ayam utuh sehingga bisa disantap untuk beberapa orang sekaligus, hampir mirip seperti ayam ingkung. Bakakak hayam bisa disajikan bersama dua macam pilihan sambal, seperti sambal merah dan sambal hijau. Selain sambal, bakakak hayam juga lebih spesial apabila dinikmati bersama lalapan sayur.",
        "Empal atau gepuk daging sapi adalah makanan yang sangat terkenal di daerah Sunda, Jawa Barat. Makanan ini bahkan menjadi salah satu menu makanan wajib yang banyak tersaji di restoran-restoran Sunda. Sesuai namanya, makanan ini dibuat dari sayatan tipis daging sapi yang dipukul-pukul alias digepuk sampai gepeng dan dimasak bersama lumuran bumbu bercita rasa manis. Setelah daging gepeng dan dibumbui, proses berikutnya adalah dengan mengungkep daging hingga bumbu meresap sampai ke tiap serat daging. Daging yang telah diungkep biasanya memiliki tekstur yang empuk. Setelah daging bertekstur empuk, empal akan digoreng hingga kering atau bisa langsung disantap tanpa harus digoreng lagi. Hidangan ini memang banyak dijual di restoran, rumah makan dan bahkan di pedagang kaki lima. Hidangan empal ini cocok disantap kapanpun dan dimanapun. Apalagi jika ditemani dengan nasi hangat, sambal segar dan bahan pelengkap lain seperti taburan bawang goreng dan kerupuk.",
        "Mi kocok adalah makanan khas Sunda yang dibuat dari bahan dasar mi kuning yang dihidangkan bersama kuah yang terbuat dari kaldu sapi. Makanan ini banyak ditemukan di kawasan Bandung. Mi kocok umumnya tersaji bersama tauge yang sudah direbus, bakso, irisan kikil, jerk nipis, dan taburan daun seledri, daun bawang, dan bawang goreng. Untuk menambah kelezatannya, bisa juga ditambahkan babat. Asal mula nama mi kocok adalah dari proses memasaknya. Mi ini dimasak dengan cara mengocok-ngocok mi nya dalam wadah khusus sembari dicelupkan ke dalam air panas. Mi kuning yang digunakan mempunyai ukuran yang pipih dengan tekstur lembut. Agar menyantap mie kocok menjadi lebih istimewa, sebagian orang biasanya memberikan kecap manis dan sambal pada kaldu kuahnya. Mie kocok saat ini sudah memiliki beberapa variasi penyajiannya, yakni dengan menambahkan bahan makanan tertentu semisal ceker ayam dan daging sapi.",
        "Sate maranggi adalah sate yang berasal dari Purwakarta, Jawa Barat. Sate maranggi menggunakan daging kambing atau daging sapi sebagai bahan utamanya. Selain di Purwakarta, sate maranggi juga banyak dijual di daerah sekitarnya hingga mencapai kawasan Cianjur. Hampir di setiap sudut kota Purwakarta terdapat warung atau penjual yang menjajakan sate maranggi dengan cara berkeliling ataupun menetap di tempat. Pembuatan sate maranggi sedikit berbeda dengan sate lainnya. Sate maranggi dibuat dengan proses merendam daging ke dalam bumbu sebelum ditusuk dan dibakar. Dikarenakan daging sudah dibumbui sebelumnya, sate maranggi tak perlu disajikan bersama saus pendamping. Meskipun tanpa saus, cita rasa sate sudah berasa di lidah karena paduan bumbu rendamannya. Sementara untuk penyajiannya sate maranggi biasanya dimakan bersama irisan bawang merah dan tomat segar.",
        "Empal gentong berbeda dengan empal gepuk. Kesamaan dari kedua jenis makanan khas Sunda ini mungkin terletak pada bahan utama yang digunakan yakni daging. Empal gentong termasuk kuliner sederhana yang saat ini telah dikenali oleh masyarakat luas. Empal gentong adalah salah satu makanan khas daerah Cirebon, Sunda Jawa Barat. Empal gentong adalah masakan sejenis gule (gulai) yang berisi potongan daging sapi cincang yang diberi kuah santan. Empal gentong biasanya dimakan dengan lontong atau nasi dan disajikan dengan cabai bubuk. Cita rasa yang ditimbulkan oleh daging sapi sangat spesial. Hal tersebut wajar ada karena saripati bumbu empal melekat di dalam gentong tersebut.",
        "Awug adalah satu dari sekian banyak makanan khas masyarakat Sunda atau Jawa Barat. Awug diolah dari tepung beras yang dicampur dengan air, garam, gula merah dan kelapa parut serta dimasak dengan cara dikukus. Dikukus dengan perabot dapur beranyam bambu bernama aseupan, yang menjadikan awug makanan khas. Selain bentuknya serupa kerucut, juga telah menjadi tradisi turun-temurun. Makanan tradisional ini tergolong ke dalam camilan. Pada saat itu, awug dimakan oleh masyarakat Sunda sebagai teman santai bersama secangkir teh hangat. Jajanan bernama unik ini dibuat dari tepung beras, kelapa, daun pandan, dan gula merah. Dari tampilan, awug mirip dengan kue putu. Bedanya, jika kue putu dikukus dalam potongan bambu kecil, awug dikukus dalam wadah berbentuk gunungan lancip yang terbuat dari anyaman bambu. Awug paling pas dinikmati saat masih hangat karena teksturnya masih legit dan rasanya manis. Beda kalau sudah dingin awug biasanya akan sedikit mengeras. Penyajian awug biasanya dilakukan di atas alas berupa daun pisang.",
        "Nasi timbel adalah makanan khas Sunda yang mempunyai cita rasa yang kuat dan unik, sangat identik dengan masakan orang Sunda. Di Sunda, nasi timbel mempunyai banyak versi sehingga banyak orang yang kadang bingung ingin mencoba nasi timbel versi yang mana. Awalnya nasi timbel merupakan bekal makanan yang biasa dibawakan untuk para petani makan di sawah. Timbel merupakan makanan khas yang disiapkan dari rumah berupa nasi hangat yang baru saja matang dan dibungkus dengan daun pisang. Panas yang berasal dari nasi akan membuat daun pisang akan sedikit matang. Nah tingkat kematangan akan menambah rasa nasi dan harum yang akan menggugah selera. Ada berbagai lauk untuk menemani nasi timbel yang pulen antara lain seperti ikan asin, pepes ikan, empal, ayam goreng, tawes, dan japuh. Tidak lupa juga terdapat lalapan serta sambal untuk menambah nilai tradisionalnya.",
        "Makanan Nasi Tutug oncom merupakan kuliner tradisional khas nusantara. Tutug oncom merupakan kuliner asli khas dari Jawa Barat. Nasi tutug oncom sendiri merupakan perpaduan nasi hangat yang dicampur dan diaduk dengan oncom bakar, disajikan dengan sedikit bawang goreng, irisan telur dadar, sambal terasi, lalapan, serta ikan asin goreng. Nasi tutug oncom ini sebetulnya adalah makanan khas Tasikmalaya. Makanan ini dinamakan tutug karena dalam bahasa Sunda mempunyai arti menumbuk. Jadi proses mengaduk dan menumbuk nasi dengan oncom di Sunda dikenal dengan nama tutug oncom. Nasi tutug oncom bisa disajikan bersama lauk pendamping seperti tahu goreng, tempe goreng, ayam goreng, lalapan sayur, dan sambal terasi."
    )

    private val foodImages = intArrayOf(
        R.drawable.karedok,
        R.drawable.lotek,
        R.drawable.bakakak,
        R.drawable.gepuk,
        R.drawable.mie_kocok,
        R.drawable.sate_maranggi,
        R.drawable.empal_gentong,
        R.drawable.awug,
        R.drawable.nasi_timbel,
        R.drawable.nasi_tutug
    )

    val listData: ArrayList<Food>
        get() {
            val list = arrayListOf<Food>()
            for (position in foodNames.indices) {
                val food = Food()
                food.name = foodNames[position]
                food.detail = foodDetails[position]
                food.photo = foodImages[position]
                list.add(food)
            }
            return list
        }
}