#pragma once
#include "Data_base.h"
namespace Курсач {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Сводка для Transfer
	/// </summary>
	public ref class Transfer : public System::Windows::Forms::Form
	{
	public:
		Transfer(void)
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
		~Transfer()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::ComboBox^  comboBox1;
	protected:
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::TextBox^  textBox2;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::Button^  button1;

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
			this->comboBox1 = (gcnew System::Windows::Forms::ComboBox());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->SuspendLayout();
			// 
			// comboBox1
			// 
			this->comboBox1->FormattingEnabled = true;
			this->comboBox1->Location = System::Drawing::Point(151, 134);
			this->comboBox1->Name = L"comboBox1";
			this->comboBox1->Size = System::Drawing::Size(145, 21);
			this->comboBox1->TabIndex = 10;
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label2->Location = System::Drawing::Point(192, 158);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(58, 20);
			this->label2->TabIndex = 9;
			this->label2->Text = L"Сумма";
			// 
			// textBox2
			// 
			this->textBox2->Location = System::Drawing::Point(175, 181);
			this->textBox2->Name = L"textBox2";
			this->textBox2->Size = System::Drawing::Size(100, 20);
			this->textBox2->TabIndex = 8;
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label1->Location = System::Drawing::Point(171, 111);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(107, 20);
			this->label1->TabIndex = 7;
			this->label1->Text = L"Номер счета";
			// 
			// button1
			// 
			this->button1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button1->Location = System::Drawing::Point(168, 207);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(117, 31);
			this->button1->TabIndex = 6;
			this->button1->Text = L"Перевести";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &Transfer::button1_Click);
			// 
			// Transfer
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ClientSize = System::Drawing::Size(446, 348);
			this->Controls->Add(this->comboBox1);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->button1);
			this->Name = L"Transfer";
			this->StartPosition = System::Windows::Forms::FormStartPosition::CenterScreen;
			this->Text = L"Transfer";
			this->Load += gcnew System::EventHandler(this, &Transfer::Transfer_Load);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void Transfer_Load(System::Object^  sender, System::EventArgs^  e) 
	{
		for (int i = 0; i < Data_base::clients->get_acc().size(); i++)
		{
			if (Data_base::clients->get_acc()[i]->get_person_acc() != Data_base::client->get_person_acc())
			{
				comboBox1->Items->Add(Data_base::clients->get_acc()[i]->get_person_acc());
			}

		}
		for (int i = 0; i < Data_base::clients->get_acc_kart().size(); i++)
		{
			if (Data_base::clients->get_acc_kart()[i]->get_person_acc() != Data_base::client_karta->get_person_acc())
			{
				comboBox1->Items->Add(Data_base::clients->get_acc_kart()[i]->get_person_acc());
			}
		}
	}

	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e)
	{
		double money;
		if (!Data_base::client->is_empty())
		{
			if (comboBox1->SelectedIndex != -1 && textBox2->Text != "")
			{
				if (Data_base::clients->search_acc_person_acc(comboBox1->SelectedItem->ToString()) != nullptr)
				{
					if (double::TryParse(textBox2->Text, money))
					{
						if (money > 0)
						{
							if (Data_base::client->get_money() - money > -1)
							{
								Data_base::client->payment(money);
								Data_base::client->add_transaction(-1 * money);
								Data_base::clients->search_acc_person_acc(comboBox1->SelectedItem->ToString())->restock(money);
								Data_base::clients->search_acc_person_acc(comboBox1->SelectedItem->ToString())->add_transaction(money);
								MessageBox::Show("Перевод совершен");
								this->Close();
							}
							else
							{
								MessageBox::Show("Недостаточно средств", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
							}
						}
						else
						{
							MessageBox::Show("Введите корректную сумму", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
						}
					}
					else
					{
						MessageBox::Show("Введите корректную сумму", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
					}
				}
				else
				{
					if (double::TryParse(textBox2->Text, money))
					{
						if (money > 0)
						{
							if (Data_base::client->get_money() - money > -1)
							{
								Data_base::client->payment(money);
								Data_base::client->add_transaction(-1 * money);
								Data_base::clients->search_acc_kart_person_acc(comboBox1->SelectedItem->ToString())->restock(money);
								Data_base::clients->search_acc_kart_person_acc(comboBox1->SelectedItem->ToString())->add_transaction(money);
								MessageBox::Show("Перевод совершен");
								this->Close();
							}
							else
							{
								MessageBox::Show("Недостаточно средств", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
							}
						}
						else
						{
							MessageBox::Show("Введите корректную сумму", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
						}
					}
					else
					{
						MessageBox::Show("Введите корректную сумму", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
					}
				}
			}
			else
			{
				MessageBox::Show("Заполните оба поля", "Ошибка ввода", MessageBoxButtons::OK, MessageBoxIcon::Error);
			}
		}
		else
		{
			if (comboBox1->SelectedIndex != -1 && textBox2->Text != "")
			{
				if (Data_base::clients->search_acc_person_acc(comboBox1->SelectedItem->ToString()) != nullptr)
				{
					if (double::TryParse(textBox2->Text, money))
					{
						if (money > 0)
						{
							if (!Data_base::client_karta->get_block())
							{
								if (Data_base::client_karta->get_money() - money > -1)
								{
									if (money < 5001)
									{
										Data_base::client_karta->payment(money);
										Data_base::client_karta->add_transaction(-1 * money);
										Data_base::clients->search_acc_person_acc(comboBox1->SelectedItem->ToString())->restock(money);
										Data_base::clients->search_acc_person_acc(comboBox1->SelectedItem->ToString())->add_transaction(money);
										MessageBox::Show("Перевод совершен");
										this->Close();
									}
									else
									{
										Data_base::client_karta->set_block(true);
										MessageBox::Show("Карта была заблокирована оператором за превышение платежа", "Блокировка", MessageBoxButtons::OK, MessageBoxIcon::Information);
										this->Close();
									}
								}
								else
								{
									MessageBox::Show("Недостаточно средств", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
								}
							}
							else
							{
								MessageBox::Show("Карта заблокирована", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
							}
						}
						else
						{
							MessageBox::Show("Введите корректную сумму", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
						}
					}
					else
					{
						MessageBox::Show("Введите корректную сумму", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
					}
				}
				else
				{

					if (double::TryParse(textBox2->Text, money))
					{
						if (money > 0)
						{

							if (money < 5001)
							{
								Data_base::client_karta->payment(money);
								Data_base::client_karta->add_transaction(-1 * money);
								Data_base::clients->search_acc_kart_person_acc(comboBox1->SelectedItem->ToString())->restock(money);
								Data_base::clients->search_acc_kart_person_acc(comboBox1->SelectedItem->ToString())->add_transaction(money);
								MessageBox::Show("Перевод совершен");
								this->Close();
							}
							else
							{
								Data_base::client_karta->set_block(true);
								MessageBox::Show("Карта была заблокирована оператором за превышение платежа", "Блокировка", MessageBoxButtons::OK, MessageBoxIcon::Information);
								this->Close();
							}
						}
						else
						{
							MessageBox::Show("Недостаточно средств", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
						}
					}
					else
					{
						MessageBox::Show("Введите корректную сумму", "Ошибка перевода", MessageBoxButtons::OK, MessageBoxIcon::Error);
					}
				}
			}
			else
			{
				MessageBox::Show("Заполните оба поля", "Ошибка ввода", MessageBoxButtons::OK, MessageBoxIcon::Error);
			}
		}
	}
};
}
