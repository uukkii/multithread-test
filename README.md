## Многопоточное (параллельное) программирование. Работа с потоками.
### Задача 1. Межпоточный диалог.

Задание реализовано в пакете **ru.netology.multithreading.homework.task1**.

Класс **ThreadSetting.java** описывает основную логику потоков. 
Метод **printStackTrace()**, вызываемый у **InterruptedException err** в блоке
catch временно закомментирован для лучшего отображения вывода работы программы 
в консоли. Далее приведены логи из консоли как с данным методом, так и без него.

В классе **Application.java** находится точка входа в программу. Там же создается
группа потоков, сами потоки, а также происходит "заморозка" потоков и
завершение потоков одной командой. 

Для удобства наполнение группы потоков и их старт вынесены в отдельный метод 
**fillAndStartThreadGroup()**;

- Вывод в консоль _**с трейсингом**_ блока **catch** переопределнного метода
**run()** класса **ThreadSetting.java**:
```
Thread #1 is started...
Thread #4 is started...
Thread #3 is started...
Thread #2 is started...
I'm Thread #3!
I'm Thread #1!
I'm Thread #4!
I'm Thread #2!
I'm Thread #3!
I'm Thread #4!
I'm Thread #1!
I'm Thread #2!
I'm Thread #3!
I'm Thread #4!
I'm Thread #1!
I'm Thread #2!
I'm Thread #1!
I'm Thread #3!
I'm Thread #4!
I'm Thread #2!
I'm Thread #1!
I'm Thread #3!
I'm Thread #2!
I'm Thread #4!
java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep(Native Method)
	at ThreadSetting.run(MyThread.java:12)
	at java.base/java.lang.Thread.run(Thread.java:831)
java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep(Native Method)
	at ThreadSetting.run(MyThread.java:12)
	at java.base/java.lang.Thread.run(Thread.java:831)
java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep(Native Method)
	at ThreadSetting.run(MyThread.java:12)
	at java.base/java.lang.Thread.run(Thread.java:831)
java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep(Native Method)
	at ThreadSetting.run(MyThread.java:12)
	at java.base/java.lang.Thread.run(Thread.java:831)
Thread #3 is finished...
Thread #1 is finished...
Thread #2 is finished...
Thread #4 is finished...

Process finished with exit code 0
```
- Вывод в консоль _**без трейсинга**_ блока **catch** переопределнного метода
  **run()** класса **MyThread.java**:
```
Thread #1 is started...
Thread #4 is started...
Thread #3 is started...
Thread #2 is started...
I'm Thread #3!
I'm Thread #1!
I'm Thread #4!
I'm Thread #2!
I'm Thread #3!
I'm Thread #4!
I'm Thread #1!
I'm Thread #2!
I'm Thread #3!
I'm Thread #4!
I'm Thread #1!
I'm Thread #2!
I'm Thread #1!
I'm Thread #3!
I'm Thread #4!
I'm Thread #2!
I'm Thread #1!
I'm Thread #3!
I'm Thread #2!
I'm Thread #4!
Thread #3 is finished...
Thread #1 is finished...
Thread #2 is finished...
Thread #4 is finished...

Process finished with exit code 0
```

### Задача 2. Межпоточный диалог со счетчиком.
Задача реализована в пакете **ru.netology.mulritreading.homework.task2**.

В классе **CallableSetting.java** описана основная логика программы. 
Метод **call()** возвращает количество сообщений (переменную типа **long** -
**msgCounter**).

В остальном логика программы аналогична логике из первого задания. Для избежания 
бесконечного цикла перед отправкой сообщения была добавлено проверка на
оставшееся время. Изначальное время задается в переменной типа **long** - 
**initialExecutionTime** и после каждого сообщения уменьшается на константу
типа **long** - **_SLEEP_TIME_**.

В классе **Application.java** находится точка входа в программу. Там же создаются
ThreadPool, Callable-задачи, Future-объекты после чего переводятся в лист. 
Для удобства обе операции помещены в метод **fillListOfTasks()**. 

Также для удобства отображения общего количества сообщений был создан метод 
**showResult()**, а также методы возврата результата для любого потока - 
**getResultByOne()**, а также возврата количества всех сообщений - **getResult()**;

Пример вывода в коннсоль после исполнения программы:

```
I'm pool-1-thread-1!
I'm pool-1-thread-4!
I'm pool-1-thread-3!
I'm pool-1-thread-2!
I'm pool-1-thread-1!
I'm pool-1-thread-2!
I'm pool-1-thread-3!
I'm pool-1-thread-4!
I'm pool-1-thread-1!
I'm pool-1-thread-2!

Number of one random thread messages: 3
Summary messages was sent: 10

Process finished with exit code 0
```
