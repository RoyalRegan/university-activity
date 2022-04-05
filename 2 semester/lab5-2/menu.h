#pragma once
#ifndef MENU_H
#define MENU_H

#include"sportsmen_strani.h" 
#include <Windows.h>

class menu
{
public:
	menu(); // смена потока ввода и вывода на русский 
	~menu();
	void show_menu(); // запуск меню
	bool proverka_1(string s); // проверка на ввод букв
	bool proverka_2(); // проверка на ввод чисел(int)
	bool proverka_3(float &a); // проверка на ввод чисел(float)
	void vvod_dannix(sportsmen &sport); // заполнение информации о спортсмене
	static void vivod_dannix(sportsmen sport); // вывод информации о спортсмене
	void add_dannie(vector<sportsmen> &sportsmens, sportsmen sport); // добавление спортсмена в список 
	void list_dannie(vector<sportsmen> sportsmens); // вывод списка спортменов
	void vvod_dannix_strani(sportsmen_strani &sport_strani); // заполнение информации о спортсмене_страны
	static void vivod_dannix_strani(sportsmen_strani sport_strani); // вывод информации о спортсмене_страны
	void add_dannie_strani(vector<sportsmen_strani> &sportsmens_strani, sportsmen_strani sport_strani); // добавление спортсмена_страны в список 
	void list_dannie_strani(vector<sportsmen_strani> sportsmens_strani); // вывод списка спортменов_страны
private:
	sportsmen vtoroi_sportsmen;
	sportsmen_strani vtoroi_sportsmen_strani;
	int vibor;
	string k,t,t1;
	float w, g;
};
#endif MENU_H