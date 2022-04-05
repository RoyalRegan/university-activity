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
		cout << "����-5" << endl;
		cout << "����-07-17 �������� �.�" << endl;
		cout << "����" << endl;
		cout << "1) ���������(����������)" << endl;
		cout << "2) ������� (���������)" << endl;
		cout << "3) �������� � �������(�����������)" << endl;
		cout << "4) ������� ������(�����������)" << endl;
		cout << "5) �� ������� �������: ��� ������, ���, ����(����������)" << endl;
		cout << "6) ����������, ���������� �� ���������� ����� ����� ������" << endl;
		cout << "7) ���������(����������_������)" << endl;
		cout << "8) ������� (���������_������)" << endl;
		cout << "9) �������� � �������(�����������_������)" << endl;
		cout << "10) ������� ������(�����������_������)" << endl;
		cout << "11) �� ������� � �����(����������_������) ������� ������� � ��� �������" << endl;
		cout << "12) ����������, ��� ���������� �� ����� ������" << endl;
		cout << "0) �����" << endl;
		cout << "��� �����: ";
		cin >> vibor;
		while (!proverka_2())
		{
			cout << "������� �����" << endl;
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
			if ((x < 'A' || x > 'Z') && (x < 'a' || x > 'z') && (x < '�' || x > '�') && (x < '�' || x > '�') && x != '�'&&x != '�')
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
	cout << "�������" << endl;
	getline(cin, s, '\n');
	while (!proverka_1(s))
	{
		cout << "������� ���������� �������" << endl;
		getline(cin, s, '\n');
	}
	sport.set_SecondName(s);
	cout << "���" << endl;
	getline(cin, f, '\n');
	while (!proverka_1(f))
	{
		cout << "������� ���������� ���" << endl;
		getline(cin, f, '\n');
	}
	sport.set_FisrtName(f);
	cout << "���� ��������(�.�.�)" << endl;
	cin >> d;
	while (!proverka_2() || (d > 31 || d < 1))
	{
		cout << "������� ���������� ����" << endl;
		cin >> d;
	}
	cin >> m;
	while (!proverka_2() || (m > 12 || m < 1))
	{
		cout << "������� ���������� �����" << endl;
		cin >> m;
	}
	cin >> y;
	while (!proverka_2() || (y > 2018 || y < 1970))
	{
		cout << "������� ���������� ���" << endl;
		cin >> y;
	}
	sport.set_Data(d, m, y);
	cout << "���" << endl;
	cin >> w;
	while (!proverka_3(w) || w > 250)
	{
		cout << "������� ���������� ���" << endl;
		cin >> w;
	}
	sport.set_Weight(w);
	cout << "����(�)" << endl;
	cin >> g;
	while (!proverka_3(g) || g>2.50)
	{
		cout << "������� ���������� ����(� ������)" << endl;
		cin >> g;
	}
	sport.set_Growth(g);
	cout << "���" << endl;
	getline(cin, S, '\n');
	while (S != "M" && S != "W" && S != "�" && S != "�"&& S != "�"&&S != "m"&&S != "�"&&S != "w")
	{
		cout << "������� ���������� ���" << endl;
		getline(cin, S, '\n');
	}
	sport.set_Sex(S);
	cout << "��� ������" << endl;
	getline(cin, k, '\n');
	while (!proverka_1(k))
	{
		cout << "������� ��������� ��� ������" << endl;
		getline(cin, k, '\n');
	}
	sport.set_KindOfSport(k);
}

void menu::vivod_dannix(sportsmen sport)
{
	cout << "�������: " << sport.get_SecondName() << endl;
	cout << "���: " << sport.get_FirstName() << endl;
	cout << "���� ��������: " << sport.get_Data_day() << "." << sport.get_Data_month() << "." << sport.get_Data_year() << endl;
	cout << "���: " << sport.get_Weight() << endl;
	cout << "����: " << sport.get_Growth() << endl;
	cout << "���: " << sport.get_Sex() << endl;
	cout << "��� ������: " << sport.get_KindOfSport() << endl;
	cout << endl;
}

void menu::add_dannie(vector<sportsmen> &sportsmens, sportsmen sport)
{
	sportsmens.push_back(sport);
}

void menu::list_dannie(vector<sportsmen> sportsmens)
{
	cout << "����������:" << endl;
	for (unsigned int i = 0; i < sportsmens.size(); i++)
	{
		cout << "�������: " << sportsmens[i].get_SecondName() << endl;
		cout << "���: " << sportsmens[i].get_FirstName() << endl;
		cout << "���� ��������: " << sportsmens[i].get_Data_day() << "." << sportsmens[i].get_Data_month() << "." << sportsmens[i].get_Data_year() << endl;
		cout << "���: " << sportsmens[i].get_Weight() << endl;
		cout << "����: " << sportsmens[i].get_Growth() << endl;
		cout << "���: " << sportsmens[i].get_Sex() << endl;
		cout << "��� ������: " << sportsmens[i].get_KindOfSport() << endl;
		cout << endl;
	}
}

void menu::vvod_dannix_strani(sportsmen_strani &sport_strani)
{
	string s, f, S, k, s1, t, t1;
	int d, m, y;
	float w, g;
	cout << "������" << endl;
	getline(cin, s1, '\n');
	while (!proverka_1(s1))
	{
		cout << "������� ���������� ������" << endl;
		getline(cin, s1, '\n');
	}
	sport_strani.set_Strana(s1);
	cout << "������� �������" << endl;
	getline(cin, t, '\n');
	while (!proverka_1(t))
	{
		cout << "������� ���������� �������" << endl;
		getline(cin, t, '\n');
	}
	sport_strani.set_TrenertSecondName(t);
	cout << "��� �������" << endl;
	getline(cin, t1, '\n');
	while (!proverka_1(t1))
	{
		cout << "������� ���������� ���" << endl;
		getline(cin, t1, '\n');
	}
	sport_strani.set_TrenertFirstName(t1);
	cout << "�������" << endl;
	getline(cin, s, '\n');
	while (!proverka_1(s))
	{
		cout << "������� ���������� �������" << endl;
		getline(cin, s, '\n');
	}
	sport_strani.set_SecondName(s);
	cout << "���" << endl;
	getline(cin, f, '\n');
	while (!proverka_1(f))
	{
		cout << "������� ���������� ���" << endl;
		getline(cin, f, '\n');
	}
	sport_strani.set_FisrtName(f);
	cout << "���� ��������(�.�.�)" << endl;
	cin >> d;
	while (!proverka_2() || (d > 31 || d < 1))
	{
		cout << "������� ���������� ����" << endl;
		cin >> d;
	}
	cin >> m;
	while (!proverka_2() || (m > 12 || m < 1))
	{
		cout << "������� ���������� �����" << endl;
		cin >> m;
	}
	cin >> y;
	while (!proverka_2() || (y > 2018 || y < 1970))
	{
		cout << "������� ���������� ���" << endl;
		cin >> y;
	}
	sport_strani.set_Data(d, m, y);
	cout << "���" << endl;
	cin >> w;
	while (!proverka_3(w) || w > 250)
	{
		cout << "������� ���������� ���" << endl;
		cin >> w;
	}
	sport_strani.set_Weight(w);
	cout << "����(�)" << endl;
	cin >> g;
	while (!proverka_3(g) || g > 2.50)
	{
		cout << "������� ���������� ����(� ������)" << endl;
		cin >> g;
	}
	sport_strani.set_Growth(g);
	cout << "���" << endl;
	getline(cin, S, '\n');
	while (S != "M" && S != "W" && S != "�" && S != "�"&& S != "�"&&S != "m"&&S != "�"&&S != "w")
	{
		cout << "������� ���������� ���" << endl;
		getline(cin, S, '\n');
	}
	sport_strani.set_Sex(S);
	cout << "��� ������" << endl;
	getline(cin, k, '\n');
	while (!proverka_1(k))
	{
		cout << "������� ��������� ��� ������" << endl;
		getline(cin, k, '\n');
	}
	sport_strani.set_KindOfSport(k);
}

void menu::vivod_dannix_strani(sportsmen_strani sport_strani)
{
	cout << "������: " << sport_strani.get_Strana() << endl;
	cout << "������� �������: " << sport_strani.get_TrenertSecondName() << endl;
	cout << "��� �������: " << sport_strani.get_TrenertFirstName() << endl;
	cout << "�������: " << sport_strani.get_SecondName() << endl;
	cout << "���: " << sport_strani.get_FirstName() << endl;
	cout << "���� ��������: " << sport_strani.get_Data_day() << "." << sport_strani.get_Data_month() << "." << sport_strani.get_Data_year() << endl;
	cout << "���: " << sport_strani.get_Weight() << endl;
	cout << "����: " << sport_strani.get_Growth() << endl;
	cout << "���: " << sport_strani.get_Sex() << endl;
	cout << "��� ������: " << sport_strani.get_KindOfSport() << endl;
	cout << endl;
}

void menu::add_dannie_strani(vector<sportsmen_strani> &sportsmens_strani, sportsmen_strani sport_strani)
{
	sportsmens_strani.push_back(sport_strani);
}

void menu::list_dannie_strani(vector<sportsmen_strani> sportsmens_strani)
{
	cout << "���������� ������" << endl;
	for (unsigned int i = 0; i < sportsmens_strani.size(); i++)
	{
		cout << "������: " << sportsmens_strani[i].get_Strana() << endl;
		cout << "������� �������: " << sportsmens_strani[i].get_TrenertSecondName() << endl;
		cout << "��� �������: " << sportsmens_strani[i].get_TrenertFirstName() << endl;
		cout << "�������: " << sportsmens_strani[i].get_SecondName() << endl;
		cout << "���: " << sportsmens_strani[i].get_FirstName() << endl;
		cout << "���� ��������: " << sportsmens_strani[i].get_Data_day() << "." << sportsmens_strani[i].get_Data_month() << "." << sportsmens_strani[i].get_Data_year() << endl;
		cout << "���: " << sportsmens_strani[i].get_Weight() << endl;
		cout << "����: " << sportsmens_strani[i].get_Growth() << endl;
		cout << "���: " << sportsmens_strani[i].get_Sex() << endl;
		cout << "��� ������: " << sportsmens_strani[i].get_KindOfSport() << endl;
		cout << endl;
	}
}

