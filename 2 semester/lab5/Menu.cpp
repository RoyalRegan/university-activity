#include "stdafx.h"
#include "menu.h"

menu::menu()
{
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
}

menu::~menu()
{

}

void menu::show_menu()
{
	while (vibor!=0)
	{
		system("cls");
		cout << "Лаба-5" << endl;
		cout << "ИКБО-07-17 Ануфриев В.В" << endl;
		cout << "Меню" << endl;
		cout << "1) Спортсмен" << endl;
		cout << "2) Спортсмен старны" << endl;
		cout << "0) Выход" << endl;
		cout << "Ваш выбор: ";
		cin >> vibor;
		system("cls");
		switch (vibor)
		{
		case 1: 
		{
			vvod_dannix(pervi_sportsmen);// заполнение полей методами 
			system("pause");
			system("cls");
			vivod_dannix(pervi_sportsmen); // вывод 

			sportsmen vtoroi_sportsmen("Ануфриев","Владислав",05,11,1999,60,170,"М","Лень");// конструктор по умолначнию 
			vivod_dannix(vtoroi_sportsmen); // вывод

			vtoroi_sportsmen.info("Ануфриев",vidspr,ves,rost); // возврат по фамилии спортсмена его вида спорта, веса, роста
			vtoroi_sportsmen.vivodinfo(vidspr,ves,rost); // вывод возврата 

			sportsmen sport;
			sport.dva_sport(pervi_sportsmen.get_KindOfSport(), vtoroi_sportsmen.get_KindOfSport()); // определение занимаются ли два спортсмена одним видом спорта
			system("pause");
			break;
		}
		case 2:
		{
			vvod_dannix_strani(pervi_sportsmen_strani); // заполнение полей методами 
			system("pause");
			system("cls");
			vivod_dannix_strani(pervi_sportsmen_strani); // вывод 

			sportsmen_strani vtoroi_stoprtsmen_strani("Ануфриев", "Владислав", 05, 11, 1999, 60, 170, "М", "Лень"); // конструктор по умолначнию(с наследованием)
			vtoroi_stoprtsmen_strani.set_Strana("Россия"); vtoroi_stoprtsmen_strani.set_TrenertSecondName("Иванович"); vtoroi_stoprtsmen_strani.set_TrenertFirstName("Иван"); // дополнение полей
			vivod_dannix_strani(vtoroi_stoprtsmen_strani); // вывод 

			vtoroi_stoprtsmen_strani.info_strani(vtoroi_stoprtsmen_strani.get_SecondName(),vtoroi_stoprtsmen_strani.get_FirstName(), trenersecondname,trenername); // возврта по фамилии и имени спортсмена, фамилиии и имени тренера
			vtoroi_stoprtsmen_strani.vivodinfo_strani(trenersecondname, trenername); // вывод возврата

			sportsmen_strani sport_strani;
			sport_strani.dva_sport_strani(pervi_sportsmen_strani.get_Strana(), vtoroi_stoprtsmen_strani.get_Strana()); // определение из одной ли страны два спортсмена
			system("pause");
			break;
		}
		default:
			break;
		}
	}
}

void menu::vvod_dannix(sportsmen &sport)
{
	string s, f, S, k;
	int d, m, y;
	float w, g;
	cin.get();
	cout << "Фамилия" << endl;
	getline(cin, s, '\n'); sport.set_SecondName(s);
	cout << "Имя" << endl;
	getline(cin, f, '\n'); sport.set_FisrtName(f);
	cout << "Дата рождения" << endl;
	cin >> d;
	while (d > 31 || d < 1)
	{
		cout << "Введите корректный день" << endl;
		cin >> d;
	}
	cin >> m;
	while (m> 12 || m< 1)
	{
		cout << "Введите корректный месяц" << endl;
		cin >> m;
	}
	cin >> y;
	while (y > 2018 || y < 1969)
	{
		cout << "Введите корректный год" << endl;
		cin >> y;
	}
	sport.set_Data(d, m, y);
	cout << "Вес" << endl;
	cin >> w; sport.set_Weight(w);
	cout << "Рост" << endl;
	cin >> g; sport.set_Growth(g);
	cin.get();
	cout << "Пол" << endl;
	getline(cin, S, '\n');
	while (S != "M" && S != "W" && S != "М" && S != "Ж"&& S != "м"&&S != "m"&&S != "ж"&&S != "w")
	{
		cout << "Введите корректный пол" << endl;
		getline(cin, S, '\n');
	}
	cout << "Вид спорта" << endl;
	getline(cin, k, '\n'); sport.set_KindOfSport(k);
}

void menu::vivod_dannix(sportsmen sport)
{
	cout << "Фамилия: "<<sport.get_SecondName()<<endl;
	cout << "Имя: "<<sport.get_FirstName()<<endl;
	cout << "Дата рождения: "<<sport.get_Data_day()<< "."<<sport.get_Data_month()<< "."<<sport.get_Data_year()<<endl;
	cout << "Вес: "<<sport.get_Weight()<<endl;
	cout << "Рост: "<<sport.get_Growth() << endl;
	cout << "Пол: "<<sport.get_Sex() << endl;
	cout << "Вид спорта: "<<sport.get_KindOfSport() << endl;
	cout << endl;
}

void menu::vvod_dannix_strani(sportsmen_strani &sport_strani)
{
	string s, f, S, k, s1, t, t1;
	int d, m, y;
	float w, g;
	cin.get();
	cout << "Страна" << endl;
	getline(cin, s1, '\n'); sport_strani.set_Strana(s1);
	cout << "Фамилия Тренера" << endl;
	getline(cin, t, '\n'); sport_strani.set_TrenertSecondName(t);
	cout << "Имя Тренера" << endl;
	getline(cin, t1, '\n'); sport_strani.set_TrenertFirstName(t1);
	cout << "Фамилия" << endl;
	getline(cin, s, '\n'); sport_strani.set_SecondName(s);
	cout << "Имя" << endl;
	getline(cin, f, '\n'); sport_strani.set_FisrtName(f);
	cout << "Дата рождения" << endl;
	cin >> d;
	while (d > 31 && d < 1)
	{
		cout << "Введите корректный день" << endl;
		cin >> d;
	}
	cin >> m;
	while (m> 12 && m< 1)
	{
		cout << "Введите корректный месяц" << endl;
		cin >> m;
	}
	cin >> y;
	while (y > 2018 && y < 1969)
	{
		cout << "Введите корректный год" << endl;
		cin >> y;
	}
	sport_strani.set_Data(d, m, y);
	cout << "Вес" << endl;
	cin >> w; sport_strani.set_Weight(w);
	cout << "Рост" << endl;
	cin >> g; sport_strani.set_Growth(g);
	cin.get();
	cout << "Пол" << endl;
	getline(cin, S, '\n');
	while (S != "M" && S != "W" && S != "М" && S != "Ж"&& S != "м"&&S != "m"&&S != "ж"&&S != "w")
	{
		cout << "Введите корректный пол" << endl;
		getline(cin, S, '\n');
	}
	cout << "Вид спорта" << endl;
	getline(cin, k, '\n'); sport_strani.set_KindOfSport(k);
}

void menu::vivod_dannix_strani(sportsmen_strani sport_strani)
{
	cout << "Страна: " << sport_strani.get_Strana()<<endl;
	cout << "Фамилия Тренера: " << sport_strani.get_TrenertSecondName()<<endl;
	cout << "Имя Тренера: " << sport_strani.get_TrenertFirstName()<<endl;
	cout << "Фамилия: " << sport_strani.get_SecondName() << endl;
	cout << "Имя: " << sport_strani.get_FirstName() << endl;
	cout << "Дата рождения: " << sport_strani.get_Data_day() << "." << sport_strani.get_Data_month() << "." << sport_strani.get_Data_year() << endl;
	cout << "Вес: " << sport_strani.get_Weight() << endl;
	cout << "Рост: " << sport_strani.get_Growth() << endl;
	cout << "Пол: " << sport_strani.get_Sex() << endl;
	cout << "Вид спорта: " << sport_strani.get_KindOfSport() << endl;
	cout << endl;
}
