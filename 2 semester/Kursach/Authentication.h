#pragma once
#include "Main.h"
#include "Data_base.h"
#include "Registration.h"
namespace Курсач {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Сводка для Authentication
	/// </summary>
	public ref class Authentication : public System::Windows::Forms::Form
	{
	public:
		Authentication(void)
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
		~Authentication()
		{
			if (components)
			{
				delete components;
			}
		}

	protected:

	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::TextBox^  textBox2;
	private: System::Windows::Forms::TextBox^  textBox1;
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::Button^  button2;

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
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->textBox2 = (gcnew System::Windows::Forms::TextBox());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->button2 = (gcnew System::Windows::Forms::Button());
			this->SuspendLayout();
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label2->Location = System::Drawing::Point(213, 124);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(67, 20);
			this->label2->TabIndex = 9;
			this->label2->Text = L"Пароль";
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label1->Location = System::Drawing::Point(216, 72);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(55, 20);
			this->label1->TabIndex = 8;
			this->label1->Text = L"Логин";
			// 
			// textBox2
			// 
			this->textBox2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->textBox2->Location = System::Drawing::Point(181, 147);
			this->textBox2->Name = L"textBox2";
			this->textBox2->Size = System::Drawing::Size(128, 26);
			this->textBox2->TabIndex = 7;
			// 
			// textBox1
			// 
			this->textBox1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->textBox1->Location = System::Drawing::Point(181, 95);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(128, 26);
			this->textBox1->TabIndex = 6;
			// 
			// button1
			// 
			this->button1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button1->Location = System::Drawing::Point(201, 176);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(89, 29);
			this->button1->TabIndex = 12;
			this->button1->Text = L"Вход";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &Authentication::button1_Click);
			// 
			// button2
			// 
			this->button2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button2->Location = System::Drawing::Point(181, 211);
			this->button2->Name = L"button2";
			this->button2->Size = System::Drawing::Size(128, 32);
			this->button2->TabIndex = 13;
			this->button2->Text = L"Регистрация";
			this->button2->UseVisualStyleBackColor = true;
			this->button2->Click += gcnew System::EventHandler(this, &Authentication::button2_Click);
			// 
			// Authentication
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ClientSize = System::Drawing::Size(490, 302);
			this->Controls->Add(this->button2);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->textBox2);
			this->Controls->Add(this->textBox1);
			this->Name = L"Authentication";
			this->StartPosition = System::Windows::Forms::FormStartPosition::CenterScreen;
			this->Text = L"Authentication";
			this->Load += gcnew System::EventHandler(this, &Authentication::Authentication_Load);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void Authentication_Load(System::Object^  sender, System::EventArgs^  e)
	{
		StreamReader^ sr = gcnew StreamReader("Клиенты.txt");
		while (!sr->EndOfStream)
		{
			Bank_Acc^ client = gcnew Bank_Acc(sr->ReadLine(), sr->ReadLine(), sr->ReadLine(), sr->ReadLine(), sr->ReadLine(), Double::Parse(sr->ReadLine()));
			client->set_person_acc();
			client->set_transactions();
			Data_base::clients->add_acc(client);
		}
		delete (IDisposable^)sr;

		StreamReader^ sr1 = gcnew StreamReader("Клиенты с картой.txt");
		while (!sr1->EndOfStream)
		{
			Bank_Acc_Kart ^client_karta = gcnew Bank_Acc_Kart(sr1->ReadLine(), sr1->ReadLine(), sr1->ReadLine(), sr1->ReadLine(), sr1->ReadLine(), Double::Parse(sr1->ReadLine()), sr1->ReadLine(), sr1->ReadLine());
			client_karta->set_person_acc();
			client_karta->set_transactions();
			client_karta->set_code();
			client_karta->set_CV2();
			client_karta->set_srok_deistvia();
			Data_base::clients->add_acc_kart(client_karta);	
		}
		delete (IDisposable^)sr1; 

		textBox2->PasswordChar = '*';
	}
	private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) 
	{
		if (textBox1->Text != "" && textBox2->Text != "")
		{
			if (Data_base::clients->search_acc_login_password(textBox1->Text, textBox2->Text) != nullptr)
			{
				Data_base::client = Data_base::clients->search_acc_login_password(textBox1->Text, textBox2->Text);
				Main^ form1 = gcnew Main;
				textBox1->Clear();
				textBox2->Clear();
				form1->ShowDialog();
			}
			else
			{
				if (Data_base::clients->search_acc_kart_login_password(textBox1->Text, textBox2->Text) != nullptr)
				{
					Data_base::client_karta = Data_base::clients->search_acc_kart_login_password(textBox1->Text, textBox2->Text);
					Main^ form1 = gcnew Main;
					textBox1->Clear();
					textBox2->Clear();
					form1->ShowDialog();
				}
				else
				{
					MessageBox::Show("Проверьте логин или пароль", "Ошибка авторизации", MessageBoxButtons::OK, MessageBoxIcon::Error);
				}
			}
		}
		else
		{
			MessageBox::Show("Заполните оба поля", "Ошибка авторизации", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
	}
	private: System::Void button2_Click(System::Object^  sender, System::EventArgs^  e) 
	{
		Registration^ form4 = gcnew Registration;
		textBox1->Clear();
		textBox2->Clear();
		form4->ShowDialog();
	}
};
}
