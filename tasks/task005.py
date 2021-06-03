def cons(a, b):
    def pair(f):
        return f(a,b)
    return pair


def func_turn_left(a, b):
    return a


def func_turn_right(a, b):
    return b


def car(p):
    #first option
    return p(lambda a,b: a)


def cdr(p):
    #second option
    return p(func_turn_right)


print(car(cons(3,4)))
print(cdr(cons(3,4)))
