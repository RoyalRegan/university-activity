// ConsoleApplication1.cpp: определяет точку входа для консольного приложения.
//
#include "stdafx.h"
#include <iostream>
#include <string>
#include <vector>
#include <Windows.h>
#include "Unit_Input_Output.h"
#include "Unit_Operation.h"
using namespace std;


vector<SportsmenInfo> Sportsmens;
vector<SportsmenInfo> NewSportsmensList;

int main()
{
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	bool Zapoln = false;
	int vbr = 10;
	while (vbr != 0)
	{
		system("cls");
		cout << "Лаба-4" << endl;
		cout << "ИКБО-07-17 Ануфриев В.В" << endl;
		cout << "Меню" << endl;
		cout << "1) Добвить спортсмена" << endl;
		cout << "2) Вывести спортсмена" << endl;
		cout << "3) Добавить спортсмена в список" << endl;
		cout << "4) Вывести список спортсменов" << endl;
		cout << "5) Отсортировать список спортсменов по весу" << endl;
		cout << "6) Сформировать список спортсменов мужчин не страше 22 лет" << endl;
		cout << "0) Выход" << endl;
		cout << "Ваш выбор: ";
		cin >> vbr;
		system("cls");
		switch (vbr)
		{
		case 1:
		{
			Zapln(Sportsmen);
			system("pause");
			break;
		}
		case 2:
		{
			Vivod(Sportsmen);
			system("pause");
			break;
		}
		case 3:
		{
			ZaplnList(Sportsmens, Sportsmen);
			system("pause");
			break;
		}
		case 4:
		{
			VivodList(Sportsmens);
			system("pause");
			break;
		}
		case 5:
		{
			Sortirovka(Sportsmens);
			system("pause");
			break;
		}
		case 6:
		{
			NewList(Sportsmens, NewSportsmensList);
			VivodList(NewSportsmensList);
			NewSportsmensList.clear();
			system("pause");
			break;
		}
		default:
			break;
		}
	}
	Sportsmens.clear();
	system("pause");
	return 0;
}
