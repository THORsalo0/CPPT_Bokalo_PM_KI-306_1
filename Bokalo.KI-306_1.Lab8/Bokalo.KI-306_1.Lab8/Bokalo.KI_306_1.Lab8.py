from Calco import Calco, ZeroInputError

class Lab8BokaloKI306:
    def main(self):
        x = 0
        try:
            x = float(input("Input your X : "))
        except ValueError:
            print("Invalid data inputted")
            return

        c = None

        try:
            c = Calco(x)
        except ZeroInputError as ex1:
            print(ex1)
            
        if c is not None:
            try:
                print("Ctg of x =", c.result())
            except ArithmeticError as ex:
                print(ex)

            self.process_and_print_results(c, "Lab8.txt", "Lab8.bin")

    def process_and_print_results(self, calco_instance, text_filename, binary_filename):
        calco_instance.in_text_file(text_filename)

        with open(text_filename, "r") as fin:
            text_content = fin.read()
            print("Result from text file =", text_content)

        calco_instance.in_binary_file(binary_filename)

        result_from_binary_file = calco_instance.read_binary_file(binary_filename)
        if result_from_binary_file is not None:
            print("Result from binary file =", result_from_binary_file)

if __name__ == "__main__":
    lab8 = Lab8BokaloKI306()
    lab8.main()
