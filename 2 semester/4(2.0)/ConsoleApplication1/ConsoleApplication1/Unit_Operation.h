
#pragma once

#include <vector>
#include "Unit_Def.h"
using namespace std;

void Sortirovka(vector<SportsmenInfo> &a); // сортировка массива структур
bool Proverka(BornData a); // проверка на возраст 2018.12.31(Год,месяц,день относительно которого смотрим возраст)
void NewList(vector<SportsmenInfo>a, vector<SportsmenInfo>&b); //новый массив структур из тех кто проходит проверку на возраст и пол

