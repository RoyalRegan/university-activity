import pylab

from lab4 import hive
from lab4.bee import sphere_bee


def print_graph(hive_inst, x_index, y_index):
    x = []
    y = []

    x_best = []
    y_best = []

    x_sel = []
    y_sel = []

    for curr_bee in hive_inst.swarm:
        if curr_bee in hive_inst.bestsites:
            x_best.append(curr_bee.position[x_index])
            y_best.append(curr_bee.position[y_index])

        elif curr_bee in hive_inst.selsites:
            x_sel.append(curr_bee.position[x_index])
            y_sel.append(curr_bee.position[y_index])

        else:
            x.append(curr_bee.position[x_index])
            y.append(curr_bee.position[y_index])

    pylab.clf()
    pylab.scatter(x, y, c='k', s=1, marker='o')

    if len(x_sel) != 0:
        pylab.scatter(x_sel, y_sel, c='b', s=20, marker='o')

    pylab.scatter(x_best, y_best, c='g', s=30, marker='o')

    pylab.show(block=False)
    pylab.pause(0.0000003)


if __name__ == "__main__":
    beetype = sphere_bee
    scoutbeecount = 100
    selectedbeecount = 10
    bestbeecount = 30
    selsitescount = 15
    bestsitescount = 5
    runcount = 1
    maxiteration = 2000
    max_func_counter = 10
    koeff = beetype.getrangekoeff()

    for runnumber in range(runcount):
        currhive = hive.hive(scoutbeecount, selectedbeecount, bestbeecount,
                             selsitescount, bestsitescount,
                             beetype.getstartrange(), beetype)

        best_func = -1.0e9

        func_counter = 0

        for n in range(maxiteration):
            currhive.nextstep()

            if currhive.bestfitness != best_func:
                best_func = currhive.bestfitness
                func_counter = 0

                print_graph(currhive, 0, 1)
            else:
                func_counter += 1
                if func_counter == max_func_counter:
                    currhive.range = [currhive.range[m] * koeff[m] for m in range(len(currhive.range))]
                    func_counter = 0

    pylab.show()
