# GuessNumber
Autor: Pablo Infantes Sosa

Version: 1.0

Esta aplicación consiste en adivinar un número dando su nombre y el número de intentos en el que quieres conseguir averiguar ese número que se genera aleatoriamente entre el uno y el 100 una vez acertado o no le llevara a una activity final la cual dira si has perdido o ganado dicho juego.

- Esta es la primera activity (ConfigActivity):

![Captura de pantalla de 2021-10-14 19-16-28](https://user-images.githubusercontent.com/91089366/137366581-0b324643-9341-41ac-9335-457fe817526c.png)

- En esta primera activity se le pide el nombre al usuario y el número de intentos para averiguar el número.
- Una vez introducidos dichos parámetros se comprobara que los campos sean correctos y que no pases una letra en el número de intentos ya que debe de ser un digito   para la adecuada funcionalidad del programa.
- Una vez que los campos sean correctos se pasara la información mediante un bundle en el que dicho bundle se le introduce a un intent para asi poderle pasar la       información a la siguiente activity.

- Esta es la segunda activity (PlayActivity):

![Captura de pantalla de 2021-10-14 19-16-52](https://user-images.githubusercontent.com/91089366/137367765-c5cd92fe-faa0-498d-80b5-27aafc3ef9f7.png)

- Esta segunda activity comienza el juego de verdad ya que debes de pasarle los números para conseguir ganar.
- El numero de intentos que pasabamos en la primera activity se guarda en esta y se comprueba que no supere dicho numero al igual que tambien se comprueba que         tampoco puedas dejar dicho campo vacio y que no le puedas meter una letra
- Y una vez dado al boton de comprobar te dira mediante dos textviews si el numero que deseas encontrar es mayor o menor
- Tambien contamos con el boton borrar para asi borrar el texto de si era mayor o menor el numero y para borrar de forma comoda para el usuario el campo donde se     introducen los numeros.
- Una vez acabado el numero de intentos o acertado el numero se le pasara a la siguiente activity el resultado de la misma forma que antes con el bundle y el intent
- y le mostrara si ha ganado o perdido de la siguiente forma

- Esta es la 3 activity (EndPlayActivity)

![Captura de pantalla de 2021-10-14 19-19-06](https://user-images.githubusercontent.com/91089366/137371207-8541b386-293e-4181-83bf-c1c81bfbeb14.png)

- En esta activity se le muestra a traves del texto si ha ganado o perdido recibiendo dicha informacion de la anterior activity de la forma que ya le comente
- Si ha ganado le pondran cuando intentos le quedaban
- Si ha perdido le pondra el numero ganador

- Dicho juego se encuentra tanto en español como en ingles.

