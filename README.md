# Решение задачек из daily coding problem

## Условие
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

```
    class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
```
The following test should pass:

``` 
    node = Node('root', Node('left', Node('left.left')), Node('right'))
    assert deserialize(serialize(node)).left.left.val == 'left.left'
```

## Пояснения к решению
Реализованно 2 варианта решения.

 1. Используя jackson
 
 2. С ручной записью информации в файл и её парсинг
 
 Первый вариант не представляет из себя ничего особенного, реализованна 
 сериализация с помощью библиотеки jackson-databind
 
 Второй вариант реализован следующим образом:
 
 Сериализация: Идёт обход дерева в глубину и информация об объекте, который
 хранится и в потомках записывается в строку по следующей схеме
 
    root{left{left.left{null;null};null};right{null;null}} 
    
  Название{левый потомок; правый потомок}
  
  Десериализация: С помощью регулярного выражения находится название
  левый потом и правый потомок. Левый и правый потом передаётся в рек
  урсивную процедуру. А название записывается в объект. 
  
  В десериализации, есть второе регулярное выражение в начале 
  рекурсивной процедуры, нужно оно, чтобы определить строку 
  типа называние{null;null}
  
  Использовал я это так как не смог сделать с помощью одного 
  регулярного выражения.
   
## Сложность алгоритма
 