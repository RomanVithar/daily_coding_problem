# Решение задачек из daily coding problem

## Условие
Given an array of integers, find the first missing positive integer
 in linear time and constant space. In other words, find the lowest 
 positive integer that does not exist in the array. The array can 
 contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. 
The input [1, 2, 0] should give 3.

## Пояснения к решению
 - Разделил массив таким образом чтобы слева были положительные числа
 а справа отрицательные.
 
 - Потом использовал каждый элемент положительной части массива как 
 индекс элемента в том же массиве который будет обозначать есть
 ли этот элемент в массиве или нет.
 Для экономии памяти использую отрицательность числа как способ 
 хранения информации типа true or false.
 
 - Прохожу ещё раз по положительной части массива и как только
 сталкиваюсь с положительным числом, что указывает на то, что
 этого числа нет в последовательности вывожу его.
 
 - Если такого элемента не оказалось вывожу size+1, где 
 size это длина положительной части.
   
## Сложность алгоритма
 время - O(n);
 память - O(1);