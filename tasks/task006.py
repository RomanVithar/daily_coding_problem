from typing import Sized


class Item:
    def __init__(self):
        self.value = None
        self.both = None
        self._pointer = None


    def get_pointer(self):
        return self._pointer

    
    def dereference_pointer(self, pointer):
        self._pointer = pointer


class LinkedLIst:
    def __init__(self):
        self.start = Item()
        self.end = Item()
        self.start.dereference_pointer(0)
        self.end.dereference_pointer(1)
        self.after_start = self.end
        self.before_end = self.start
        self.memory = []
        self.memory.append(self.start)
        self.memory.append(self.end)
        self.size = 0 


    def add(self, element):
        item = Item()
        item.value = element
        item.dereference_pointer(len(self.memory))
        item.both = self.before_end.get_pointer() ^ self.end.get_pointer()
        if(self.before_end != self.start):
            bb_end = self._get_follow(self.before_end, self.end)
            self.before_end.both = bb_end.get_pointer() ^ item.get_pointer()
        else:
            self.after_start = item
        self.before_end = item
        self.memory.append(item)
        self.size += 1


    def _get_follow(self, current, opposite):
        return self.memory[current.both ^ opposite.get_pointer()]


    def get(self, index):
        if index > self.size:
            return None 
        count = 0
        before = self.start
        current = self.after_start
        while count != index:
            temp = current
            current = self._get_follow(current, before)
            before = temp
            count += 1
        return current.value

    def __len__(self):
        return self.size


list = LinkedLIst()
list.add('first')
list.add('second')
list.add('third')
list.add('fourth')
print(len(list))
print(list.get(3))
print(list.get(1))
print(list.get(0))
print(list.get(3))