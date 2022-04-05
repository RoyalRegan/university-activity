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
	/// Сводка для Change_PIN
	/// </summary>
	public ref class Change_PIN : public System::Windows::Forms::Form
	{
	public:
		Change_PIN(void)
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
		~Change_PIN()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::Button^  button1;
	protected:
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::TextBox^  textBox2;
	private: System::Windows::Forms::TextBox^  textBox1;

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
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->SuspendLayout();
			// 
			// button1
			// 
			this->button1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button1->ForeColor = System::Drawing::SystemColors::ControlText;
			this->button1->Location = System::Drawing::Point(84, 171);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(112, 31);
			this->button1->TabIndex = 9;
			this->button1->Text = L"Установить";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &Change_PIN::button1_Click_1);
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label2->Location = System::Drawing::Point(86, 116);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(115, 20);
			this->label2->TabIndex = 8;
			this->label2->Text = L"Подтвердить";
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label1->Location = System::Drawing::Point(114, 61);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(35, 20);
			this->label1->TabIndex = 7;
			this->label1->Text = L"PIN";
			// 
			// textBox2
			// 
			this->textBox2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->textBox2->Location = System::Drawing::Point(90, 139);
			this->textBox2->Name = L"textBox2";
			this->textBox2->Size = System::Drawing::Size(100, 26);
			this->textBox2->TabIndex = 6;
			// 
			// textBox1
			// 
			this->textBox1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->textBox1->Location = System::Drawing::Point(89, 84);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(100, 26);
			this->textBox1->TabIndex = 5;
			// 
			// Change_PIN
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ClientSize = System::Drawing::Size(284, 262);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->textBox1);
			this->Name = L"Change_PIN";
			this->StartPosition = System::Windows::Forms::FormStartPosition::CenterScreen;
			this->Text = L"Change_PIN";
			this->Load += gcnew System::EventHandler(this, &Change_PIN::Change_PIN_Load);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
		bool pin_chek(String^ s)
		{
			if (s->Length != 4)
			{
				return false;
			}
			else
			{
				for (int i = 0; i < s->Length; i++)
				{
					if (s[i]<'0' || s[i]>'9')
					{
						return false;
					}
				}
			}
			return true;
		}

	private: System::Void Change_PIN_Load(System::Object^  sender, System::EventArgs^  e) 
	{
		textBox1->PasswordChar = '*';
		textBox2->PasswordChar = '*';
		MessageBox::Show("Введите новый PIN");
	}

	private: System::Void button1_Click_1(System::Object^  sender, System::EventArgs^  e) 
	{
		if (pin_chek(textBox1->Text) && pin_chek(textBox2->Text))
		{
			if (textBox1->Text == textBox2->Text)
			{
				if (Data_base::client->is_empty())
				{
					Data_base::client_karta->set_PIN(textBox1->Text);
					Data_base::client_karta->set_code();
					Data_base::client_karta->set_CV2();
					Data_base::client_karta->set_srok_deistvia();
					Data_base::client_karta->set_block(false);
					MessageBox::Show("Карта перевыпущена");
					this->Close();
				}
				else
				{
					Data_base::client_karta->add_kart(Data_base::client, textBox1->Text);
					Data_base::clients->del_acc(Data_base::client);
					Data_base::clients->add_acc_kart(Data_base::client_karta);
					Data_base::client = gcnew Bank_Acc;
					MessageBox::Show("Карта выпущена");
					this->Close();
				}
			}
			else
			{
				MessageBox::Show("Поля должны совпадать", "Ошибка применения", MessageBoxButtons::OK, MessageBoxIcon::Error);
			}
		}
		else
		{
			MessageBox::Show("PIN может содержать только 4 цифры", "Ошибка применения", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
	}
};
}
