#pragma once
#include "Shop.h"
#include "Transfer.h"
#include"Change_PIN.h"
#include"PIN.h"
#include"Restock.h"
#include"Withdraw.h"
#include "Data_base.h"
namespace Курсач {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Сводка для Main
	/// </summary>
	public ref class Main : public System::Windows::Forms::Form
	{
	public:
		Main(void)
		{
			InitializeComponent();
			//
			//TODO: добавьте код конструктора
			//
		}

	protected:
		/// <summary>
		/// Освободить все используемые ресурсы.
		/// </summary>
		~Main()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::GroupBox^  groupBox1;
	protected:
	private: System::Windows::Forms::Button^  button10;
	private: System::Windows::Forms::Button^  button9;
	private: System::Windows::Forms::Button^  button2;
	private: System::Windows::Forms::Button^  button3;
	private: System::Windows::Forms::Button^  button5;
	private: System::Windows::Forms::Button^  button7;
	private: System::Windows::Forms::Button^  button8;
	private: System::Windows::Forms::Button^  button4;
	private: System::Windows::Forms::Label^  label9;
	private: System::Windows::Forms::Label^  label8;
	private: System::Windows::Forms::Label^  label7;
	private: System::Windows::Forms::Button^  button6;
	private: System::Windows::Forms::Label^  label6;
	private: System::Windows::Forms::Label^  label5;
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::ListBox^  listBox1;

	private:
		/// <summary>
		/// Обязательная переменная конструктора.
		/// </summary>
		System::ComponentModel::Container ^components;

#pragma region Windows Form Designer generated code
		/// <summary>
		/// Требуемый метод для поддержки конструктора — не изменяйте 
		/// содержимое этого метода с помощью редактора кода.
		/// </summary>
		void InitializeComponent(void)
		{
			this->groupBox1 = (gcnew System::Windows::Forms::GroupBox());
			this->button10 = (gcnew System::Windows::Forms::Button());
			this->button9 = (gcnew System::Windows::Forms::Button());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->button3 = (gcnew System::Windows::Forms::Button());
			this->button5 = (gcnew System::Windows::Forms::Button());
			this->button7 = (gcnew System::Windows::Forms::Button());
			this->button8 = (gcnew System::Windows::Forms::Button());
			this->button4 = (gcnew System::Windows::Forms::Button());
			this->label9 = (gcnew System::Windows::Forms::Label());
			this->label8 = (gcnew System::Windows::Forms::Label());
			this->label7 = (gcnew System::Windows::Forms::Label());
			this->button6 = (gcnew System::Windows::Forms::Button());
			this->label6 = (gcnew System::Windows::Forms::Label());
			this->label5 = (gcnew System::Windows::Forms::Label());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->listBox1 = (gcnew System::Windows::Forms::ListBox());
			this->groupBox1->SuspendLayout();
			this->SuspendLayout();
			// 
			// groupBox1
			// 
			this->groupBox1->Controls->Add(this->button10);
			this->groupBox1->Controls->Add(this->button9);
			this->groupBox1->Controls->Add(this->button2);
			this->groupBox1->Controls->Add(this->button3);
			this->groupBox1->Controls->Add(this->button5);
			this->groupBox1->Controls->Add(this->button7);
			this->groupBox1->Controls->Add(this->button8);
			this->groupBox1->Controls->Add(this->button4);
			this->groupBox1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->groupBox1->Location = System::Drawing::Point(12, 403);
			this->groupBox1->Name = L"groupBox1";
			this->groupBox1->Size = System::Drawing::Size(533, 224);
			this->groupBox1->TabIndex = 40;
			this->groupBox1->TabStop = false;
			this->groupBox1->Text = L"Кнопочки";
			// 
			// button10
			// 
			this->button10->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button10->Location = System::Drawing::Point(358, 91);
			this->button10->Name = L"button10";
			this->button10->Size = System::Drawing::Size(147, 54);
			this->button10->TabIndex = 28;
			this->button10->Text = L"Снять блокировку";
			this->button10->UseVisualStyleBackColor = true;
			this->button10->Click += gcnew System::EventHandler(this, &Main::button10_Click);
			// 
			// button9
			// 
			this->button9->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button9->Location = System::Drawing::Point(19, 159);
			this->button9->Name = L"button9";
			this->button9->Size = System::Drawing::Size(147, 54);
			this->button9->TabIndex = 27;
			this->button9->Text = L"Вывод со счета";
			this->button9->UseVisualStyleBackColor = true;
			this->button9->Click += gcnew System::EventHandler(this, &Main::button9_Click);
			// 
			// button2
			// 
			this->button2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button2->Location = System::Drawing::Point(19, 19);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(147, 54);
			this->button2->TabIndex = 18;
			this->button2->Text = L"Покупка(КК)";
			this->button2->UseVisualStyleBackColor = true;
			this->button2->Click += gcnew System::EventHandler(this, &Main::button2_Click);
			// 
			// button3
			// 
			this->button3->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button3->Location = System::Drawing::Point(184, 19);
			this->button3->Name = L"button3";
			this->button3->Size = System::Drawing::Size(147, 54);
			this->button3->TabIndex = 19;
			this->button3->Text = L"Перевод на счет";
			this->button3->UseVisualStyleBackColor = true;
			this->button3->Click += gcnew System::EventHandler(this, &Main::button3_Click);
			// 
			// button5
			// 
			this->button5->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button5->Location = System::Drawing::Point(184, 91);
			this->button5->Name = L"button5";
			this->button5->Size = System::Drawing::Size(147, 54);
			this->button5->TabIndex = 21;
			this->button5->Text = L"Блокировка КК";
			this->button5->UseVisualStyleBackColor = true;
			this->button5->Click += gcnew System::EventHandler(this, &Main::button5_Click);
			// 
			// button7
			// 
			this->button7->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button7->Location = System::Drawing::Point(184, 159);
			this->button7->Name = L"button7";
			this->button7->Size = System::Drawing::Size(147, 54);
			this->button7->TabIndex = 25;
			this->button7->Text = L"Выпустить/Перевыпустить КК";
			this->button7->UseVisualStyleBackColor = true;
			this->button7->Click += gcnew System::EventHandler(this, &Main::button7_Click);
			// 
			// button8
			// 
			this->button8->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button8->Location = System::Drawing::Point(19, 91);
			this->button8->Name = L"button8";
			this->button8->Size = System::Drawing::Size(147, 54);
			this->button8->TabIndex = 26;
			this->button8->Text = L"Пополнение счета";
			this->button8->UseVisualStyleBackColor = true;
			this->button8->Click += gcnew System::EventHandler(this, &Main::button8_Click);
			// 
			// button4
			// 
			this->button4->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button4->Location = System::Drawing::Point(358, 19);
			this->button4->Name = L"button4";
			this->button4->Size = System::Drawing::Size(147, 54);
			this->button4->TabIndex = 20;
			this->button4->Text = L"Аннулирование счета";
			this->button4->UseVisualStyleBackColor = true;
			this->button4->Click += gcnew System::EventHandler(this, &Main::button4_Click);
			// 
			// label9
			// 
			this->label9->AutoSize = true;
			this->label9->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label9->Location = System::Drawing::Point(8, 79);
			this->label9->Name = L"label9";
			this->label9->Size = System::Drawing::Size(14, 20);
			this->label9->TabIndex = 39;
			this->label9->Text = L"-";
			// 
			// label8
			// 
			this->label8->AutoSize = true;
			this->label8->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label8->Location = System::Drawing::Point(8, 130);
			this->label8->Name = L"label8";
			this->label8->Size = System::Drawing::Size(14, 20);
			this->label8->TabIndex = 38;
			this->label8->Text = L"-";
			// 
			// label7
			// 
			this->label7->AutoSize = true;
			this->label7->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label7->Location = System::Drawing::Point(8, 286);
			this->label7->Name = L"label7";
			this->label7->Size = System::Drawing::Size(14, 20);
			this->label7->TabIndex = 37;
			this->label7->Text = L"-";
			// 
			// button6
			// 
			this->button6->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button6->Location = System::Drawing::Point(12, 12);
			this->button6->Name = L"button6";
			this->button6->Size = System::Drawing::Size(84, 30);
			this->button6->TabIndex = 36;
			this->button6->Text = L"Выход";
			this->button6->UseVisualStyleBackColor = true;
			this->button6->Click += gcnew System::EventHandler(this, &Main::button6_Click);
			// 
			// label6
			// 
			this->label6->AutoSize = true;
			this->label6->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label6->Location = System::Drawing::Point(8, 181);
			this->label6->Name = L"label6";
			this->label6->Size = System::Drawing::Size(88, 20);
			this->label6->TabIndex = 35;
			this->label6->Text = L"Карты нет";
			// 
			// label5
			// 
			this->label5->AutoSize = true;
			this->label5->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label5->Location = System::Drawing::Point(8, 161);
			this->label5->Name = L"label5";
			this->label5->Size = System::Drawing::Size(170, 20);
			this->label5->TabIndex = 34;
			this->label5->Text = L"Информация о карте";
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label4->Location = System::Drawing::Point(8, 110);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(111, 20);
			this->label4->TabIndex = 33;
			this->label4->Text = L"Номер счета:";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label3->Location = System::Drawing::Point(9, 59);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(215, 20);
			this->label3->TabIndex = 32;
			this->label3->Text = L"Информация о владельце:";
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label1->Location = System::Drawing::Point(307, 9);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(101, 20);
			this->label1->TabIndex = 31;
			this->label1->Text = L"Транзакции:";
			// 
			// listBox1
			// 
			this->listBox1->BackColor = System::Drawing::SystemColors::Control;
			this->listBox1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->listBox1->FormattingEnabled = true;
			this->listBox1->ItemHeight = 20;
			this->listBox1->Location = System::Drawing::Point(311, 32);
			this->listBox1->Name = L"listBox1";
			this->listBox1->Size = System::Drawing::Size(234, 284);
			this->listBox1->TabIndex = 30;
			// 
			// Main
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ClientSize = System::Drawing::Size(560, 642);
			this->Controls->Add(this->groupBox1);
			this->Controls->Add(this->label9);
			this->Controls->Add(this->label8);
			this->Controls->Add(this->label7);
			this->Controls->Add(this->button6);
			this->Controls->Add(this->label6);
			this->Controls->Add(this->label5);
			this->Controls->Add(this->label4);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->listBox1);
			this->Name = L"Main";
			this->StartPosition = System::Windows::Forms::FormStartPosition::CenterScreen;
			this->Text = L"Main";
			this->Load += gcnew System::EventHandler(this, &Main::Main_Load);
			this->groupBox1->ResumeLayout(false);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
		void refresh()
		{
			if (!Data_base::client_karta->is_empty())
			{
				label7->Text = "Баланс: " + Data_base::client_karta->get_money().ToString();
				label6->Text = "Код:" + Data_base::client_karta->get_code() + "\n" + "CV2:" + Data_base::client_karta->get_CV2() + "\n" + "PIN:" + Data_base::client_karta->get_PIN() + "\n" + "Срок действия:" + Data_base::client_karta->get_month() + "/" + Data_base::client_karta->get_year();
				if (Data_base::client_karta->get_block())
				{
					label6->Text += "\n" + "Состояние карты: заблокирована";
				}
				else
				{
					label6->Text += "\n" + "Состояние карты: активна";
				}
				map <int, double> k = Data_base::client_karta->get_transactions();
				listBox1->Items->Clear();
				for (auto it = k.begin(); it != k.end(); ++it)
				{
					listBox1->Items->Add("№" + (*it)->first + "  " + (*it)->second.ToString() + "р");
				}
			}
			else
			{
				label7->Text = "Баланс: " + Data_base::client->get_money().ToString();
				listBox1->Items->Clear();
				map <int, double> trans = Data_base::client->get_transactions();
				for (auto it = trans.begin(); it != trans.end(); ++it)
				{
					listBox1->Items->Add("№" + (*it)->first + "  " + (*it)->second.ToString() + "р");
				}
			}
		}

	private: System::Void Main_Load(System::Object^  sender, System::EventArgs^  e) 
	{
		if (!Data_base::client_karta->is_empty())
		{
			label8->Text = Data_base::client_karta->get_person_acc();
			label9->Text = Data_base::client_karta->get_secondName() + " " + Data_base::client_karta->get_firstName() + " " + Data_base::client_karta->get_patronymic();
			label6->Text = "Код:" + Data_base::client_karta->get_code() + "\n" + "CV2:" + Data_base::client_karta->get_CV2() + "\n" + "PIN:" + Data_base::client_karta->get_PIN() + "\n" + "Срок действия:" + Data_base::client_karta->get_month() + "/" + Data_base::client_karta->get_year();
			if (Data_base::client_karta->get_block())
			{
				label6->Text += "\n" + "Состояние карты: заблокирована";
			}
			else
			{
				label6->Text += "\n" + "Состояние карты: активна";
			}
			label7->Text = "Баланс: " + Data_base::client_karta->get_money().ToString();
			map <int, double> trans = Data_base::client_karta->get_transactions();
			for (auto it = trans.begin(); it != trans.end(); ++it)
			{
				listBox1->Items->Add("№" + (*it)->first + "  " + (*it)->second.ToString() + "р");
			}
		}
		else
		{
			label8->Text = Data_base::client->get_person_acc();
			label9->Text = Data_base::client->get_secondName() + " " + Data_base::client->get_firstName() + " " + Data_base::client->get_patronymic();
			label7->Text = "Баланс: " + Data_base::client->get_money().ToString();
			map <int, double> trans = Data_base::client->get_transactions();
			for (auto it = trans.begin(); it != trans.end(); ++it)
			{
				listBox1->Items->Add("№" + (*it)->first + "  " + (*it)->second.ToString() + "р");
			}
		}
	}

	private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (Data_base::client_karta->is_empty())
		{
			MessageBox::Show("У вас нет КК ", "Ошибка перенаправления", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
		else
		{
			if (!Data_base::client_karta->get_block())
			{
				Shop^ form2 = gcnew Shop();
				form2->ShowDialog();
				refresh();
			}
			else
			{
				MessageBox::Show("КК заблокирована", "Ошибка перенаправления", MessageBoxButtons::OK, MessageBoxIcon::Error);
			}
		}
	}

	private: System::Void button3_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (!Data_base::client_karta->get_block())
		{
			Transfer^ form3 = gcnew Transfer();
			form3->ShowDialog();
			refresh();
		}
		else
		{
			MessageBox::Show("КК заблокирована", "Ошибка перенаправления", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}

	}

	private: System::Void button4_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (Data_base::client_karta->is_empty())
		{
			Data_base::client->set_money(0);
			button2->Enabled = false;
			button3->Enabled = false;
			button4->Enabled = false;
			button5->Enabled = false;
			button7->Enabled = false;
			button8->Enabled = false;
			button9->Enabled = false;
			button10->Enabled = false;
			Data_base::clients->del_acc(Data_base::client);
			refresh();

		}
		else
		{
			Data_base::client_karta->set_money(0);
			Data_base::client_karta->set_block(true);
			button2->Enabled = false;
			button3->Enabled = false;
			button4->Enabled = false;
			button5->Enabled = false;
			button7->Enabled = false;
			button8->Enabled = false;
			button9->Enabled = false;
			button10->Enabled = false;
			Data_base::clients->del_acc_kart(Data_base::client_karta);
			refresh();
		}
		MessageBox::Show("Счет аннулирован");
	}

	private: System::Void button5_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (!Data_base::client_karta->is_empty())
		{
			if (!Data_base::client_karta->get_block())
			{
				Data_base::client_karta->set_block(true);
				MessageBox::Show("Карта заблокирована");
				refresh();
			}
			else
			{
				MessageBox::Show("КК уже заблокирована ", "Ошибка перенаправления", MessageBoxButtons::OK, MessageBoxIcon::Error);
			}
		}
		else
		{
			MessageBox::Show("У вас нет КК  ", "Ошибка перенаправления", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
	}

	private: System::Void button6_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (!Data_base::client->is_empty())
		{
			Data_base::client = gcnew Bank_Acc;
		}
		else
		{
			Data_base::client_karta = gcnew Bank_Acc_Kart;
		}
		this->Close();
	}

	private: System::Void button7_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (!Data_base::client->is_empty())
		{
			Change_PIN^ forma5 = gcnew Change_PIN;
			forma5->ShowDialog();
			refresh();
		}
		else
		{
			PIN ^ forma6 = gcnew PIN;
			forma6->ShowDialog();
			if (PIN::check_pin)
			{
				Change_PIN^ forma5 = gcnew Change_PIN;
				forma5->ShowDialog();
				refresh();
			}
		}
	}

	private: System::Void button8_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (!Data_base::client_karta->get_block())
		{
			Restock^ forma7 = gcnew Restock;
			forma7->ShowDialog();
			refresh();
		}
		else
		{
			MessageBox::Show("КК заблокирована", "Ошибка перенаправления", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}

	}
	private: System::Void button9_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (!Data_base::client_karta->get_block())
		{
			Withdraw^ forma8 = gcnew Withdraw;
			forma8->ShowDialog();
			refresh();
		}
		else
		{
			MessageBox::Show("КК заблокирована", "Ошибка перенаправления", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}

	}
	private: System::Void button10_Click(System::Object^  sender, System::EventArgs^  e)
	{
		if (!Data_base::client_karta->is_empty())
		{
			if (Data_base::client_karta->get_block())
			{
				PIN ^ forma6 = gcnew PIN;
				forma6->ShowDialog();
				if (PIN::check_pin)
				{
					Data_base::client_karta->set_block(false);
					PIN::check_pin = false;
					MessageBox::Show("Карта разблокирована");
					refresh();
				}
			}
			else
			{
				MessageBox::Show("КК не заблокирована ", "Ошибка перенаправления", MessageBoxButtons::OK, MessageBoxIcon::Error);
			}
		}
		else
		{
			MessageBox::Show("У вас нет КК  ", "Ошибка перенаправления", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
	}
	private: System::Void MyForm_FormClosed(System::Object^  sender, System::Windows::Forms::FormClosedEventArgs^  e)
	{
		button6->PerformClick();
	}
};
}
