// Лаба-5 версия 2.cpp: определяет точку входа для консольного приложения.
//
#include "stdafx.h"
#include"menu.h"

int main()
{
	menu::menu();
	sportsmen pervi_sportsmen("Ануфриев", "Владислав", 05, 11, 1999, 60, 170, "М", "Лень"); // заполнение с помощью конструктора
	sportsmen_strani pervi_stoprtsmen_strani("Ануфриев", "Владислав", 05, 11, 1999, 60, 170, "М", "Лень"); // заполнение наследника с помощью конструктора 
	pervi_stoprtsmen_strani.set_Strana("Россия"); pervi_stoprtsmen_strani.set_TrenertSecondName("Иванович"); pervi_stoprtsmen_strani.set_TrenertFirstName("Иван"); // дополнение полей наследника
	cout << "Введенные с помощью конструктора спортсмены:" << endl<<endl;
	menu::vivod_dannix(pervi_sportsmen);
	menu::vivod_dannix_strani(pervi_stoprtsmen_strani);
	system("pause");
	menu menushka;
	menushka.show_menu();
	system("pause");
	return 0;
}


