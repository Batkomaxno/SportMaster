# SportMaster
Annotation
Пункт Предусмотреть возможность запуска тестов в разных браузерах одновременно c использованием Selenoid доконца выполнить не удалось, 
не нашел документации по запуску с несколькими браузерами, не успел разобратьься хотя xml для запуска в многопоточном режиме написал. 
Тесты через селеноид успешно проходит на локале

Тест-кейс №1
1.Зайти на сайт sportmaster.ru
2.Ввести в поиск «Bauer BTH18 SUPREME 2S PRO»
3.Нажать кнопку «Enter»
- Поиск не дал результатов
4.Ввести в поиск «BTH18 SUPREME 2S PRO»
5.Нажать в выпадающем списке по товару BTH18 SUPREME 2S PRO
- Проверить что кнопка «В корзину» не доступна
6.Ввести в поиск «BTH18 SUPREME S27»
7.Нажать в выпадающем списке по товару BTH18 SUPREME S27
- Проверить что кнопка «В Корзину» доступна
- Проверить что есть кнопка «Купить в 1 клик»
8.Перейти на сайт sportmaster.ru
9.Через выпадающий список категорий перейти в «Ледовые коньки и хоккей» - «Коньки»
10.Установить в фильтре бренд «Bauer» 
11.Кликнуть по товару BTH18 SUPREME S27
- Проверить что кнопка «В Корзину» доступна
- Проверить что есть кнопка «Купить в 1 клик»
