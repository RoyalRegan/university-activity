#pragma once
#include"Data_base.h"
namespace Курсач {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Сводка для Restock
	/// </summary>
	public ref class Restock : public System::Windows::Forms::Form
	{
	public:
		Restock(void)
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
		~Restock()
		{
			if (components)
			{
				delete components;
			}
		}

	protected:
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::TextBox^  textBox1;
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
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->SuspendLayout();
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label1->Location = System::Drawing::Point(111, 87);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(58, 20);
			this->label1->TabIndex = 10;
			this->label1->Text = L"Сумма";
			// 
			// textBox1
			// 
			this->textBox1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->textBox1->Location = System::Drawing::Point(81, 111);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(123, 26);
			this->textBox1->TabIndex = 9;
			// 
			// button1
			// 
			this->button1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button1->Location = System::Drawing::Point(87, 141);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(111, 32);
			this->button1->TabIndex = 12;
			this->button1->Text = L"Пополнить";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &Restock::button1_Click);
			// 
			// Restock
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ClientSize = System::Drawing::Size(284, 262);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->textBox1);
			this->Name = L"Restock";
			this->StartPosition = System::Windows::Forms::FormStartPosition::CenterScreen;
			this->Text = L"Restock";
			this->Load += gcnew System::EventHandler(this, &Restock::Restock_Load);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void Restock_Load(System::Object^  sender, System::EventArgs^  e) 
	{

	}

	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e)
	{
		double money;
		if (double::TryParse(textBox1->Text, money))
		{
			if (money > 0)
			{
				if (!Data_base::client->is_empty())
				{
					Data_base::client->restock(money);
					Data_base::client->add_transaction(money);
					MessageBox::Show("Пополнение совершено");
					this->Close();
				}
				else
				{
					if (money < 5001)
					{
						Data_base::client_karta->restock(money);
						Data_base::client_karta->add_transaction(money);
						MessageBox::Show("Пополнение совершено");
						this->Close();
					}
					else
					{
						Data_base::client_karta->set_block(true);
						MessageBox::Show("Карта была заблокирована оператором за превышение платежа", "Блокировка", MessageBoxButtons::OK, MessageBoxIcon::Information);
						this->Close();
					}
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
};
}
