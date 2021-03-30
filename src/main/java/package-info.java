/*
 * Singleton:   применён - в InputProccessor создается лишь один экземпляр класса Person
 * Factory:     (не)применён - почему
 * Builder:     применён - Builder внутри класса Person. Теперь не загроможден InputProcessor,
вся логика по сборке в отдельном классе.Но пришлось убрать идентификатор final с полей Person,
 иначе оставлся бы конструктор для Person с большим количеством параметров. Но сделала сам экземпляр
 person final, чтобы его не менять
 * Adapter:     (не)применён - почему
 * Bridge:      (не)применён - почему
 * Facade:      применён - В интерфейсе Generator создала default метод getParam, чтобы заменить поиск
 конкретных параметров. Например, теперь в инициализации каждого параметра вместо
final FioGenerator fioGenerator = new FioGenerator();
fioGenerator.generateParams(intCode);
this.fio = fioGenerator.buildResponse();
Получаем
this.fio=new FioGenerator().getParam(intCode,new FioGenerator());
Такой вызов мне, если честно, самой не нравится, но лучше не получилось
(статический метод в интерфейсе не создашь...).
Но все же лучше, чем постоянно повторять код при генерации каждого параметра
 * DTO:         применён - создан класс Fio для хранения данных, меньше кода в FioGenerator и в Person
 для этого - FioGenerator implements Generator. И процесс генерации тоже можно обобщить
 * Шаблон:      (не)применён - почему
 */