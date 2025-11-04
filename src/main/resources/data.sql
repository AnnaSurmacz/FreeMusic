-- data.sql – pełny katalog albumów pod front
-- Uwaga na testy: czyści tabelę, żeby INSERT-y nie duplikowały rekordów
DELETE FROM ALBUMS;

-- === ŚWIĄTECZNE ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('christmas1','Świąteczna muzyka 1','świąteczne','Klimat świąteczny 1. Ciepłe tło świąteczne do lokalu.',36.00,'/covers/christmas1.jpg','/previews/christmas1.mp3','christmas1.zip'),
                                                                                                 ('christmas2','Świąteczna muzyka 2','świąteczne','Klimat świąteczny 2. Spokojne zimowe brzmienie.',36.00,'/covers/christmas2.jpg','/previews/christmas2.mp3','christmas2.zip'),
                                                                                                 ('christmas3','Świąteczna muzyka 3','świąteczne','Klimat świąteczny 3. Delikatne tło zakupowe.',36.00,'/covers/christmas3.jpg','/previews/christmas3.mp3','christmas3.zip'),
                                                                                                 ('christmas4','Świąteczna muzyka 4','świąteczne','Klimat świąteczny 4. Lounge zimowy.',36.00,'/covers/christmas4.jpg','/previews/christmas4.mp3','christmas4.zip'),
                                                                                                 ('christmas5','Świąteczna muzyka 5','świąteczne','Klimat świąteczny 5. Lekki jazz zimowy.',36.00,'/covers/christmas5.jpg','/previews/christmas5.mp3','christmas5.zip'),
                                                                                                 ('christmas6','Świąteczna muzyka 6','świąteczne','Klimat świąteczny 6. Ciepłe melodie w tle.',36.00,'/covers/christmas6.jpg','/previews/christmas6.mp3','christmas6.zip');

-- === WŁOSKA ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('italian1','Włoska muzyka 1','Włoska','Włoski klimat 1. Placeholder opisu.',36.00,'/covers/italian1.jpg','/previews/italian1.mp3','italian1.zip'),
                                                                                                 ('italian2','Włoska muzyka 2','Włoska','Włoski klimat 2. Placeholder opisu.',36.00,'/covers/italian2.jpg','/previews/italian2.mp3','italian2.zip'),
                                                                                                 ('italian3','Włoska muzyka 3','Włoska','Włoski klimat 3. Placeholder opisu.',36.00,'/covers/italian3.jpg','/previews/italian3.mp3','italian3.zip'),
                                                                                                 ('italian4','Włoska muzyka 4','Włoska','Włoski klimat 4. Placeholder opisu.',36.00,'/covers/italian4.jpg','/previews/italian4.mp3','italian4.zip'),
                                                                                                 ('italian_christmas','Włoska muzyka świąteczna','Włoska','Włoska muzyka świąteczna. Świąteczne brzmienia w stylu włoskim.',36.00,'/covers/italian_christmas.jpg','/previews/italian_christmas.mp3','italian_christmas.zip');

-- === GRECKA ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('greek1','Grecka muzyka 1','Grecka','Grecki klimat 1. Placeholder opisu.',36.00,'/covers/greek1.jpg','/previews/greek1.mp3','greek1.zip'),
                                                                                                 ('greek2','Grecka muzyka 2','Grecka','Grecki klimat 2. Placeholder opisu.',36.00,'/covers/greek2.jpg','/previews/greek2.mp3','greek2.zip'),
                                                                                                 ('greek3','Grecka muzyka 3','Grecka','Grecki klimat 3. Placeholder opisu.',36.00,'/covers/greek3.jpg','/previews/greek3.mp3','greek3.zip'),
                                                                                                 ('greek4','Grecka muzyka 4','Grecka','Grecki klimat 4. Placeholder opisu.',36.00,'/covers/greek4.jpg','/previews/greek4.mp3','greek4.zip'),
                                                                                                 ('greek_christmas','Grecka muzyka świąteczna','Grecka','Greckie świąteczne klimaty. Świąteczne granie w stylu greckim.',36.00,'/covers/greek_christmas.jpg','/previews/greek_christmas.mp3','greek_christmas.zip');

-- === TURECKA ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('turkish1','Turecka muzyka 1','Turecka','Turecki klimat 1. Placeholder opisu.',36.00,'/covers/turkish1.jpg','/previews/turkish1.mp3','turkish1.zip'),
                                                                                                 ('turkish2','Turecka muzyka 2','Turecka','Turecki klimat 2. Placeholder opisu.',36.00,'/covers/turkish2.jpg','/previews/turkish2.mp3','turkish2.zip'),
                                                                                                 ('turkish3','Turecka muzyka 3','Turecka','Turecki klimat 3. Placeholder opisu.',36.00,'/covers/turkish3.jpg','/previews/turkish3.mp3','turkish3.zip'),
                                                                                                 ('turkish4','Turecka muzyka 4','Turecka','Turecki klimat 4. Placeholder opisu.',36.00,'/covers/turkish4.jpg','/previews/turkish4.mp3','turkish4.zip');

-- === AZJATYCKA ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('asian1_chinese','Azjatycka muzyka (chińska) 1','Azjatycka','Chiński / orientalny klimat 1. Placeholder opisu.',36.00,'/covers/asian1_chinese.jpg','/previews/asian1_chinese.mp3','asian1_chinese.zip'),
                                                                                                 ('asian2_chinese','Azjatycka muzyka (chińska) 2','Azjatycka','Chiński / orientalny klimat 2. Placeholder opisu.',36.00,'/covers/asian2_chinese.jpg','/previews/asian2_chinese.mp3','asian2_chinese.zip'),
                                                                                                 ('asian3_vietnamese','Azjatycka muzyka (wietnamska) 1','Azjatycka','Wietnamski / azjatycki klimat 1. Placeholder opisu.',36.00,'/covers/asian3_vietnamese.jpg','/previews/asian3_vietnamese.mp3','asian3_vietnamese.zip'),
                                                                                                 ('asian4_vietnamese','Azjatycka muzyka (wietnamska) 2','Azjatycka','Wietnamski / azjatycki klimat 2. Placeholder opisu.',36.00,'/covers/asian4_vietnamese.jpg','/previews/asian4_vietnamese.mp3','asian4_vietnamese.zip'),
                                                                                                 ('asian5_thai','Azjatycka muzyka (tajska) 1','Azjatycka','Tajski / orientalny klimat 1. Placeholder opisu.',36.00,'/covers/asian5_thai.jpg','/previews/asian5_thai.mp3','asian5_thai.zip'),
                                                                                                 ('asian6_thai','Azjatycka muzyka (tajska) 2','Azjatycka','Tajski / orientalny klimat 2. Placeholder opisu.',36.00,'/covers/asian6_thai.jpg','/previews/asian6_thai.mp3','asian6_thai.zip');

-- === INDYJSKA ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('indian1','Indyjska muzyka 1','Indyjska','Indyjski klimat 1. Placeholder opisu.',36.00,'/covers/indian1.jpg','/previews/indian1.mp3','indian1.zip'),
                                                                                                 ('indian2','Indyjska muzyka 2','Indyjska','Indyjski klimat 2. Placeholder opisu.',36.00,'/covers/indian2.jpg','/previews/indian2.mp3','indian2.zip'),
                                                                                                 ('indian3','Indyjska muzyka 3','Indyjska','Indyjski klimat 3. Placeholder opisu.',36.00,'/covers/indian3.jpg','/previews/indian3.mp3','indian3.zip'),
                                                                                                 ('indian4','Indyjska muzyka 4','Indyjska','Indyjski klimat 4. Placeholder opisu.',36.00,'/covers/indian4.jpg','/previews/indian4.mp3','indian4.zip');

-- === HISZPAŃSKA ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('spain1','Hiszpańska muzyka 1','Hiszpańska','Hiszpański klimat 1. Placeholder opisu.',36.00,'/covers/spain1.jpg','/previews/spain1.mp3','spain1.zip'),
                                                                                                 ('spain2','Hiszpańska muzyka 2','Hiszpańska','Hiszpański klimat 2. Placeholder opisu.',36.00,'/covers/spain2.jpg','/previews/spain2.mp3','spain2.zip'),
                                                                                                 ('spain3','Hiszpańska muzyka 3','Hiszpańska','Hiszpański klimat 3. Placeholder opisu.',36.00,'/covers/spain3.jpg','/previews/spain3.mp3','spain3.zip'),
                                                                                                 ('spain4','Hiszpańska muzyka 4','Hiszpańska','Hiszpański klimat 4. Placeholder opisu.',36.00,'/covers/spain4.jpg','/previews/spain4.mp3','spain4.zip');

-- === COUNTRY ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('country1','Country 1','Country','Country / amerykański klimat 1. Placeholder opisu.',36.00,'/covers/country1.jpg','/previews/country1.mp3','country1.zip'),
                                                                                                 ('country2','Country 2','Country','Country / amerykański klimat 2. Placeholder opisu.',36.00,'/covers/country2.jpg','/previews/country2.mp3','country2.zip'),
                                                                                                 ('country3','Country 3','Country','Country / amerykański klimat 3. Placeholder opisu.',36.00,'/covers/country3.jpg','/previews/country3.mp3','country3.zip'),
                                                                                                 ('country4','Country 4','Country','Country / amerykański klimat 4. Placeholder opisu.',36.00,'/covers/country4.jpg','/previews/country4.mp3','country4.zip');

-- === POP ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('pop1','Pop ambient 1','Pop','Pop ambient 1. Placeholder opisu.',36.00,'/covers/pop1.jpg','/previews/pop1.mp3','pop1.zip'),
                                                                                                 ('pop2','Pop ambient 2','Pop','Pop ambient 2. Placeholder opisu.',36.00,'/covers/pop2.jpg','/previews/pop2.mp3','pop2.zip'),
                                                                                                 ('pop3','Pop ambient 3','Pop','Pop ambient 3. Placeholder opisu.',36.00,'/covers/pop3.jpg','/previews/pop3.mp3','pop3.zip'),
                                                                                                 ('pop4','Pop ambient 4','Pop','Pop ambient 4. Placeholder opisu.',36.00,'/covers/pop4.jpg','/previews/pop4.mp3','pop4.zip');

-- === JAZZ ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('jazz1','Jazz lounge 1','Jazz','Delikatny jazz 1. Placeholder opisu.',36.00,'/covers/jazz1.jpg','/previews/jazz1.mp3','jazz1.zip'),
                                                                                                 ('jazz2','Jazz lounge 2','Jazz','Delikatny jazz 2. Placeholder opisu.',36.00,'/covers/jazz2.jpg','/previews/jazz2.mp3','jazz2.zip'),
                                                                                                 ('jazz3','Jazz lounge 3','Jazz','Delikatny jazz 3. Placeholder opisu.',36.00,'/covers/jazz3.jpg','/previews/jazz3.mp3','jazz3.zip'),
                                                                                                 ('jazz4','Jazz lounge 4','Jazz','Delikatny jazz 4. Placeholder opisu.',36.00,'/covers/jazz4.jpg','/previews/jazz4.mp3','jazz4.zip');

-- === REGGAE ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('reggae1','Reggae chill 1','Reggae','Reggae / chill bar 1. Placeholder opisu.',36.00,'/covers/reggae1.jpg','/previews/reggae1.mp3','reggae1.zip'),
                                                                                                 ('reggae2','Reggae chill 2','Reggae','Reggae / chill bar 2. Placeholder opisu.',36.00,'/covers/reggae2.jpg','/previews/reggae2.mp3','reggae2.zip'),
                                                                                                 ('reggae3','Reggae chill 3','Reggae','Reggae / chill bar 3. Placeholder opisu.',36.00,'/covers/reggae3.jpg','/previews/reggae3.mp3','reggae3.zip'),
                                                                                                 ('reggae4','Reggae chill 4','Reggae','Reggae / chill bar 4. Placeholder opisu.',36.00,'/covers/reggae4.jpg','/previews/reggae4.mp3','reggae4.zip');

-- === BEZ WOKALU / HANDEL ===
INSERT INTO ALBUMS (slug, name, genre, description, price, cover_url, preview_url, file_key) VALUES
                                                                                                 ('handel1','Instrumental do sklepu 1','Bez wokalu / Handel','Instrumental / do lokali handlowych 1.',36.00,'/covers/handel1.jpg','/previews/handel1.mp3','handel1.zip'),
                                                                                                 ('handel2','Instrumental do sklepu 2','Bez wokalu / Handel','Instrumental / do lokali handlowych 2.',36.00,'/covers/handel2.jpg','/previews/handel2.mp3','handel2.zip'),
                                                                                                 ('handel3','Instrumental do sklepu 3','Bez wokalu / Handel','Instrumental / do lokali handlowych 3.',36.00,'/covers/handel3.jpg','/previews/handel3.mp3','handel3.zip'),
                                                                                                 ('handel4','Instrumental do sklepu 4','Bez wokalu / Handel','Instrumental / do lokali handlowych 4.',36.00,'/covers/handel4.jpg','/previews/handel4.mp3','handel4.zip');