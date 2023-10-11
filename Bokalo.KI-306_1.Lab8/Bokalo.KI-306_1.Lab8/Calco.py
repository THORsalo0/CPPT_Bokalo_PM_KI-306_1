import math
import pickle


class ZeroInputError(Exception):
    pass

class Calco:
    def __init__(self, x):
        if x == 0:
            raise ZeroInputError("Exception: X is equal to 0!!!")
        self.x = x
        self.ctg = 0

    def result(self):
        if self.x == 0:
            raise ArithmeticError("Exception: X is equal to 0!!!")
        try:
            self.ctg = 1 / math.tan(self.x)
        except ZeroDivisionError:
            raise ArithmeticError("Exception: Division by zero error!")
        return self.ctg

    def in_text_file(self, filename):
        try:
            with open(filename, "w") as fout:
                fout.write(str(self.result()))
        except IOError:
            print("Can't use the file!!!")
        except ArithmeticError as a:
            print(a)

    def in_binary_file(self, filename):
        try:
            with open(filename, "wb") as fout:
                pickle.dump(self.result(), fout)
        except IOError:
            print("Can't use the file!!!")
        except ArithmeticError as a:
            print(a)

    def read_binary_file(self, filename):
        try:
            with open(filename, "rb") as fin:
                result = pickle.load(fin)
                if result is None:
                    raise ArithmeticError("Exception: Result is not available in the file!!!")
                return result
        except IOError:
            print("Can't read the file!!!")
            return None
        except ArithmeticError as a:
            print(a)
