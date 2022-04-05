from random import sample

import matplotlib.pyplot as plt

from neural import Neural


def generate_dots(count):
    dots = []
    for i in range(count):
        dots.append(sample(range(62, 77), 2))

    for i in range(count):
        dots.append(sample(range(22, 37), 2))

    return dots


def teach(n, in_dots):
    global t_iteration
    t_iteration += 1

    for dot in in_dots:
        n.input_data = dot
        if n.calculate() == 0:
            return False

    return True


def print_dots(dots, color):
    for dot in dots:
        plt.scatter(dot[0], dot[1], s=1, c=color)


def test(n, dots):
    i_dots = []
    o_dots = []
    for dot in dots:
        n.input_data = dot
        if n.calculate() == 1:
            i_dots.append(dots)
        else:
            o_dots.append(dots)
    print(f"Не распознала {o_dots}")
    print(f"Распознала {i_dots}")


if __name__ == "__main__":
    t_iteration = 0
    ###########Config graphic###########
    plt.xlim(0, 100)
    plt.ylim(0, 100)
    plt.scatter([25, 75, 25, 75], [25, 75, 75, 25], s=13000, facecolors='none', edgecolors='r')

    i_dots = [[26, 26], [76, 76], [23, 23], [83, 65], [20, 87], [87, 20], [21, 15], [71, 15]]

    print_dots(i_dots, 'r')

    neural = Neural([])

    #############Teaching#############
    while not teach(neural, i_dots):
        print(neural.weight)
        neural.calc_weight()

    print(f'Обучение пройдено финальные веса: {neural.weight}\nКол-во итераци {t_iteration}')

    #############Testing#############
    dots = generate_dots(100)

    print_dots(dots, 'g')

    test(neural, dots)

    dots = []
    for i in range(15):
        dots.append(sample(range(1, 100), 2))

    print_dots(dots, 'k')

    test(neural, dots)

    plt.show()
