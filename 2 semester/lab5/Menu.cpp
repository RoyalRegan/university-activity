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
		cout << "����-5" << endl;
		cout << "����-07-17 �������� �.�" << endl;
		cout << "����" << endl;
		cout << "1) ���������" << endl;
		cout << "2) ��������� ������" << endl;
		cout << "0) �����" << endl;
		cout << "��� �����: ";
		cin >> vibor;
		system("cls");
		switch (vibor)
		{
		case 1: 
		{
			vvod_dannix(pervi_sportsmen);// ���������� ����� �������� 
			system("pause");
			system("cls");
			vivod_dannix(pervi_sportsmen); // ����� 

			sportsmen vtoroi_sportsmen("��������","���������",05,11,1999,60,170,"�","����");// ����������� �� ���������� 
			vivod_dannix(vtoroi_sportsmen); // �����

			vtoroi_sportsmen.info("��������",vidspr,ves,rost); // ������� �� ������� ���������� ��� ���� ������, ����, �����
			vtoroi_sportsmen.vivodinfo(vidspr,ves,rost); // ����� �������� 

			sportsmen sport;
			sport.dva_sport(pervi_sportsmen.get_KindOfSport(), vtoroi_sportsmen.get_KindOfSport()); // ����������� ���������� �� ��� ���������� ����� ����� ������
			system("pause");
			break;
		}
		case 2:
		{
			vvod_dannix_strani(pervi_sportsmen_strani); // ���������� ����� �������� 
			system("pause");
			system("cls");
			vivod_dannix_strani(pervi_sportsmen_strani); // ����� 

			sportsmen_strani vtoroi_stoprtsmen_strani("��������", "���������", 05, 11, 1999, 60, 170, "�", "����"); // ����������� �� ����������(� �������������)
			vtoroi_stoprtsmen_strani.set_Strana("������"); vtoroi_stoprtsmen_strani.set_TrenertSecondName("��������"); vtoroi_stoprtsmen_strani.set_TrenertFirstName("����"); // ���������� �����
			vivod_dannix_strani(vtoroi_stoprtsmen_strani); // ����� 

			vtoroi_stoprtsmen_strani.info_strani(vtoroi_stoprtsmen_strani.get_SecondName(),vtoroi_stoprtsmen_strani.get_FirstName(), trenersecondname,trenername); // ������� �� ������� � ����� ����������, �������� � ����� �������
			vtoroi_stoprtsmen_strani.vivodinfo_strani(trenersecondname, trenername); // ����� ��������

			sportsmen_strani sport_strani;
			sport_strani.dva_sport_strani(pervi_sportsmen_strani.get_Strana(), vtoroi_stoprtsmen_strani.get_Strana()); // ����������� �� ����� �� ������ ��� ����������
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
	cout << "�������" << endl;
	getline(cin, s, '\n'); sport.set_SecondName(s);
	cout << "���" << endl;
	getline(cin, f, '\n'); sport.set_FisrtName(f);
	cout << "���� ��������" << endl;
	cin >> d;
	while (d > 31 || d < 1)
	{
		cout << "������� ���������� ����" << endl;
		cin >> d;
	}
	cin >> m;
	while (m> 12 || m< 1)
	{
		cout << "������� ���������� �����" << endl;
		cin >> m;
	}
	cin >> y;
	while (y > 2018 || y < 1969)
	{
		cout << "������� ���������� ���" << endl;
		cin >> y;
	}
	sport.set_Data(d, m, y);
	cout << "���" << endl;
	cin >> w; sport.set_Weight(w);
	cout << "����" << endl;
	cin >> g; sport.set_Growth(g);
	cin.get();
	cout << "���" << endl;
	getline(cin, S, '\n');
	while (S != "M" && S != "W" && S != "�" && S != "�"&& S != "�"&&S != "m"&&S != "�"&&S != "w")
	{
		cout << "������� ���������� ���" << endl;
		getline(cin, S, '\n');
	}
	cout << "��� ������" << endl;
	getline(cin, k, '\n'); sport.set_KindOfSport(k);
}

void menu::vivod_dannix(sportsmen sport)
{
	cout << "�������: "<<sport.get_SecondName()<<endl;
	cout << "���: "<<sport.get_FirstName()<<endl;
	cout << "���� ��������: "<<sport.get_Data_day()<< "."<<sport.get_Data_month()<< "."<<sport.get_Data_year()<<endl;
	cout << "���: "<<sport.get_Weight()<<endl;
	cout << "����: "<<sport.get_Growth() << endl;
	cout << "���: "<<sport.get_Sex() << endl;
	cout << "��� ������: "<<sport.get_KindOfSport() << endl;
	cout << endl;
}

void menu::vvod_dannix_strani(sportsmen_strani &sport_strani)
{
	string s, f, S, k, s1, t, t1;
	int d, m, y;
	float w, g;
	cin.get();
	cout << "������" << endl;
	getline(cin, s1, '\n'); sport_strani.set_Strana(s1);
	cout << "������� �������" << endl;
	getline(cin, t, '\n'); sport_strani.set_TrenertSecondName(t);
	cout << "��� �������" << endl;
	getline(cin, t1, '\n'); sport_strani.set_TrenertFirstName(t1);
	cout << "�������" << endl;
	getline(cin, s, '\n'); sport_strani.set_SecondName(s);
	cout << "���" << endl;
	getline(cin, f, '\n'); sport_strani.set_FisrtName(f);
	cout << "���� ��������" << endl;
	cin >> d;
	while (d > 31 && d < 1)
	{
		cout << "������� ���������� ����" << endl;
		cin >> d;
	}
	cin >> m;
	while (m> 12 && m< 1)
	{
		cout << "������� ���������� �����" << endl;
		cin >> m;
	}
	cin >> y;
	while (y > 2018 && y < 1969)
	{
		cout << "������� ���������� ���" << endl;
		cin >> y;
	}
	sport_strani.set_Data(d, m, y);
	cout << "���" << endl;
	cin >> w; sport_strani.set_Weight(w);
	cout << "����" << endl;
	cin >> g; sport_strani.set_Growth(g);
	cin.get();
	cout << "���" << endl;
	getline(cin, S, '\n');
	while (S != "M" && S != "W" && S != "�" && S != "�"&& S != "�"&&S != "m"&&S != "�"&&S != "w")
	{
		cout << "������� ���������� ���" << endl;
		getline(cin, S, '\n');
	}
	cout << "��� ������" << endl;
	getline(cin, k, '\n'); sport_strani.set_KindOfSport(k);
}

void menu::vivod_dannix_strani(sportsmen_strani sport_strani)
{
	cout << "������: " << sport_strani.get_Strana()<<endl;
	cout << "������� �������: " << sport_strani.get_TrenertSecondName()<<endl;
	cout << "��� �������: " << sport_strani.get_TrenertFirstName()<<endl;
	cout << "�������: " << sport_strani.get_SecondName() << endl;
	cout << "���: " << sport_strani.get_FirstName() << endl;
	cout << "���� ��������: " << sport_strani.get_Data_day() << "." << sport_strani.get_Data_month() << "." << sport_strani.get_Data_year() << endl;
	cout << "���: " << sport_strani.get_Weight() << endl;
	cout << "����: " << sport_strani.get_Growth() << endl;
	cout << "���: " << sport_strani.get_Sex() << endl;
	cout << "��� ������: " << sport_strani.get_KindOfSport() << endl;
	cout << endl;
}
