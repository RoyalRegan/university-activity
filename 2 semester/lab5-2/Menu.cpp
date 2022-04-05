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
	vector<sportsmen> sportsmens;
	vector<sportsmen_strani> sportsmens_strani;
	while (vibor != 0)
	{
		system("cls");
		cout << "Лаба-5" << endl;
		cout << "ИКБО-07-17 Ануфриев В.В" << endl;
		cout << "Меню" << endl;
		cout << "1) Заполнить(спортсмена)" << endl;
		cout << "2) Вывести (спортмена)" << endl;
		cout << "3) Добавить в массива(спортсменов)" << endl;
		cout << "4) Вывести массив(спортсменов)" << endl;
		cout << "5) По фамилии вернуть: Вид спорта, Вес, Рост(спортсмена)" << endl;
		cout << "6) Определить, занимаются ли спортсмены одним видом спорта" << endl;
		cout << "7) Заполнить(спортсмена_страны)" << endl;
		cout << "8) Вывести (спортмена_страны)" << endl;
		cout << "9) Добавить в массива(спортсменов_страны)" << endl;
		cout << "10) Вывести массив(спортсменов_страны)" << endl;
		cout << "11) По фамилии и имени(спортсмена_страны) вернуть фамилию и имя тренера" << endl;
		cout << "12) Определить, два спортсмена из одной страны" << endl;
		cout << "0) Выход" << endl;
		cout << "Ваш выбор: ";
		cin >> vibor;
		while (!proverka_2())
		{
			cout << "Введите число" << endl;
			cin >> vibor;
		}
		system("cls");
		switch (vibor)
		{
		case 1:
		{
			vvod_dannix(vtoroi_sportsmen);
			system("pause");
			break;
		}
		case 2:
		{
			vivod_dannix(vtoroi_sportsmen);
			system("pause");
			break;
		}
		case 3:
		{
			add_dannie(sportsmens, vtoroi_sportsmen);
			system("pause");
			break;
		}
		case 4:
		{
			list_dannie(sportsmens);
			system("pause");
			break;
		}
		case 5:
		{
			vtoroi_sportsmen.info(sportsmens, k, w, g);
			system("pause");
			break;
		}
		case 6:
		{
			vtoroi_sportsmen.dva_sport(sportsmens);
			system("pause");
			break;
		}
		case 7:
		{
			vvod_dannix_strani(vtoroi_sportsmen_strani);
			system("pause");
			break;
		}
		case 8:
		{
			vivod_dannix_strani(vtoroi_sportsmen_strani);
			system("pause");
			break;
		}
		case 9:
		{
			add_dannie_strani(sportsmens_strani, vtoroi_sportsmen_strani);
			system("pause");
			break;
		}
		case 10:
		{
			list_dannie_strani(sportsmens_strani);
			system("pause");
			break;
		}
		case 11:
		{
			vtoroi_sportsmen_strani.info_strani(sportsmens_strani, t, t1);
			system("pause");
			break;
		}
		case 12:
		{
			vtoroi_sportsmen_strani.dva_sport(sportsmens_strani);
			system("pause");
			break;
		}
		default:
			break;
		}
	}
}

bool menu::proverka_1(string s)
{
	if (s != "")
	{
		for (auto x : s)
		{
			if ((x < 'A' || x > 'Z') && (x < 'a' || x > 'z') && (x < 'А' || x > 'Я') && (x < 'а' || x > 'я') && x != 'Ё'&&x != 'ё')
			{
				return false;
			}
		}
	}
	else
	{
		return false;
	}
	return true;
}

bool menu::proverka_2()
{
	cin.clear();
	string s;
	getline(cin, s, '\n');
	for (auto x : s)
	{
		if (x<'0' || x>'9')
		{
			cin.clear();
			return false;
		}
	}
	return true;
}

bool menu::proverka_3(float &a)
{
	cin.clear();
	string s;
	getline(cin, s, '\n');
	for (auto x : s)
	{
		if (x<'0' || x>'9')
		{
			cin.clear();
			return false;
		}
	}
	a = round(a * 10) / 10;
	return true;
}

void menu::vvod_dannix(sportsmen &sport)
{
	string s, f, S, k;
	int d, m, y;
	float w, g;
	cout << "Фамилия" << endl;
	getline(cin, s, '\n');
	while (!proverka_1(s))
	{
		cout << "Введите корректную фамилию" << endl;
		getline(cin, s, '\n');
	}
	sport.set_SecondName(s);
	cout << "Имя" << endl;
	getline(cin, f, '\n');
	while (!proverka_1(f))
	{
		cout << "Введите корректное имя" << endl;
		getline(cin, f, '\n');
	}
	sport.set_FisrtName(f);
	cout << "Дата рождения(д.м.г)" << endl;
	cin >> d;
	while (!proverka_2() || (d > 31 || d < 1))
	{
		cout << "Введите корректный день" << endl;
		cin >> d;
	}
	cin >> m;
	while (!proverka_2() || (m > 12 || m < 1))
	{
		cout << "Введите корректный месяц" << endl;
		cin >> m;
	}
	cin >> y;
	while (!proverka_2() || (y > 2018 || y < 1970))
	{
		cout << "Введите корректный год" << endl;
		cin >> y;
	}
	sport.set_Data(d, m, y);
	cout << "Вес" << endl;
	cin >> w;
	while (!proverka_3(w) || w > 250)
	{
		cout << "Введите корректный вес" << endl;
		cin >> w;
	}
	sport.set_Weight(w);
	cout << "Рост(м)" << endl;
	cin >> g;
	while (!proverka_3(g) || g>2.50)
	{
		cout << "Введите корректный рост(в метрах)" << endl;
		cin >> g;
	}
	sport.set_Growth(g);
	cout << "Пол" << endl;
	getline(cin, S, '\n');
	while (S != "M" && S != "W" && S != "М" && S != "Ж"&& S != "м"&&S != "m"&&S != "ж"&&S != "w")
	{
		cout << "Введите корректный пол" << endl;
		getline(cin, S, '\n');
	}
	sport.set_Sex(S);
	cout << "Вид спорта" << endl;
	getline(cin, k, '\n');
	while (!proverka_1(k))
	{
		cout << "Введите корректый вид спорта" << endl;
		getline(cin, k, '\n');
	}
	sport.set_KindOfSport(k);
}

void menu::vivod_dannix(sportsmen sport)
{
	cout << "Фамилия: " << sport.get_SecondName() << endl;
	cout << "Имя: " << sport.get_FirstName() << endl;
	cout << "Дата рождения: " << sport.get_Data_day() << "." << sport.get_Data_month() << "." << sport.get_Data_year() << endl;
	cout << "Вес: " << sport.get_Weight() << endl;
	cout << "Рост: " << sport.get_Growth() << endl;
	cout << "Пол: " << sport.get_Sex() << endl;
	cout << "Вид спорта: " << sport.get_KindOfSport() << endl;
	cout << endl;
}

void menu::add_dannie(vector<sportsmen> &sportsmens, sportsmen sport)
{
	sportsmens.push_back(sport);
}

void menu::list_dannie(vector<sportsmen> sportsmens)
{
	cout << "Спортсмены:" << endl;
	for (unsigned int i = 0; i < sportsmens.size(); i++)
	{
		cout << "Фамилия: " << sportsmens[i].get_SecondName() << endl;
		cout << "Имя: " << sportsmens[i].get_FirstName() << endl;
		cout << "Дата рождения: " << sportsmens[i].get_Data_day() << "." << sportsmens[i].get_Data_month() << "." << sportsmens[i].get_Data_year() << endl;
		cout << "Вес: " << sportsmens[i].get_Weight() << endl;
		cout << "Рост: " << sportsmens[i].get_Growth() << endl;
		cout << "Пол: " << sportsmens[i].get_Sex() << endl;
		cout << "Вид спорта: " << sportsmens[i].get_KindOfSport() << endl;
		cout << endl;
	}
}

void menu::vvod_dannix_strani(sportsmen_strani &sport_strani)
{
	string s, f, S, k, s1, t, t1;
	int d, m, y;
	float w, g;
	cout << "Страна" << endl;
	getline(cin, s1, '\n');
	while (!proverka_1(s1))
	{
		cout << "Введите корректную страну" << endl;
		getline(cin, s1, '\n');
	}
	sport_strani.set_Strana(s1);
	cout << "Фамилия Тренера" << endl;
	getline(cin, t, '\n');
	while (!proverka_1(t))
	{
		cout << "Введите корректную фамилию" << endl;
		getline(cin, t, '\n');
	}
	sport_strani.set_TrenertSecondName(t);
	cout << "Имя Тренера" << endl;
	getline(cin, t1, '\n');
	while (!proverka_1(t1))
	{
		cout << "Введите корректное имя" << endl;
		getline(cin, t1, '\n');
	}
	sport_strani.set_TrenertFirstName(t1);
	cout << "Фамилия" << endl;
	getline(cin, s, '\n');
	while (!proverka_1(s))
	{
		cout << "Введите корректную фамилию" << endl;
		getline(cin, s, '\n');
	}
	sport_strani.set_SecondName(s);
	cout << "Имя" << endl;
	getline(cin, f, '\n');
	while (!proverka_1(f))
	{
		cout << "Введите корректное имя" << endl;
		getline(cin, f, '\n');
	}
	sport_strani.set_FisrtName(f);
	cout << "Дата рождения(д.м.г)" << endl;
	cin >> d;
	while (!proverka_2() || (d > 31 || d < 1))
	{
		cout << "Введите корректный день" << endl;
		cin >> d;
	}
	cin >> m;
	while (!proverka_2() || (m > 12 || m < 1))
	{
		cout << "Введите корректный месяц" << endl;
		cin >> m;
	}
	cin >> y;
	while (!proverka_2() || (y > 2018 || y < 1970))
	{
		cout << "Введите корректный год" << endl;
		cin >> y;
	}
	sport_strani.set_Data(d, m, y);
	cout << "Вес" << endl;
	cin >> w;
	while (!proverka_3(w) || w > 250)
	{
		cout << "Введите корректный вес" << endl;
		cin >> w;
	}
	sport_strani.set_Weight(w);
	cout << "Рост(м)" << endl;
	cin >> g;
	while (!proverka_3(g) || g > 2.50)
	{
		cout << "Введите корректный рост(в метрах)" << endl;
		cin >> g;
	}
	sport_strani.set_Growth(g);
	cout << "Пол" << endl;
	getline(cin, S, '\n');
	while (S != "M" && S != "W" && S != "М" && S != "Ж"&& S != "м"&&S != "m"&&S != "ж"&&S != "w")
	{
		cout << "Введите корректный пол" << endl;
		getline(cin, S, '\n');
	}
	sport_strani.set_Sex(S);
	cout << "Вид спорта" << endl;
	getline(cin, k, '\n');
	while (!proverka_1(k))
	{
		cout << "Введите корректый вид спорта" << endl;
		getline(cin, k, '\n');
	}
	sport_strani.set_KindOfSport(k);
}

void menu::vivod_dannix_strani(sportsmen_strani sport_strani)
{
	cout << "Страна: " << sport_strani.get_Strana() << endl;
	cout << "Фамилия Тренера: " << sport_strani.get_TrenertSecondName() << endl;
	cout << "Имя Тренера: " << sport_strani.get_TrenertFirstName() << endl;
	cout << "Фамилия: " << sport_strani.get_SecondName() << endl;
	cout << "Имя: " << sport_strani.get_FirstName() << endl;
	cout << "Дата рождения: " << sport_strani.get_Data_day() << "." << sport_strani.get_Data_month() << "." << sport_strani.get_Data_year() << endl;
	cout << "Вес: " << sport_strani.get_Weight() << endl;
	cout << "Рост: " << sport_strani.get_Growth() << endl;
	cout << "Пол: " << sport_strani.get_Sex() << endl;
	cout << "Вид спорта: " << sport_strani.get_KindOfSport() << endl;
	cout << endl;
}

void menu::add_dannie_strani(vector<sportsmen_strani> &sportsmens_strani, sportsmen_strani sport_strani)
{
	sportsmens_strani.push_back(sport_strani);
}

void menu::list_dannie_strani(vector<sportsmen_strani> sportsmens_strani)
{
	cout << "Спортсмены страна" << endl;
	for (unsigned int i = 0; i < sportsmens_strani.size(); i++)
	{
		cout << "Страна: " << sportsmens_strani[i].get_Strana() << endl;
		cout << "Фамилия Тренера: " << sportsmens_strani[i].get_TrenertSecondName() << endl;
		cout << "Имя Тренера: " << sportsmens_strani[i].get_TrenertFirstName() << endl;
		cout << "Фамилия: " << sportsmens_strani[i].get_SecondName() << endl;
		cout << "Имя: " << sportsmens_strani[i].get_FirstName() << endl;
		cout << "Дата рождения: " << sportsmens_strani[i].get_Data_day() << "." << sportsmens_strani[i].get_Data_month() << "." << sportsmens_strani[i].get_Data_year() << endl;
		cout << "Вес: " << sportsmens_strani[i].get_Weight() << endl;
		cout << "Рост: " << sportsmens_strani[i].get_Growth() << endl;
		cout << "Пол: " << sportsmens_strani[i].get_Sex() << endl;
		cout << "Вид спорта: " << sportsmens_strani[i].get_KindOfSport() << endl;
		cout << endl;
	}
}

