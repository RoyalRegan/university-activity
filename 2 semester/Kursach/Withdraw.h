#pragma once
#include "Data_Base.h"
namespace ������ {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// ������ ��� Withdraw
	/// </summary>
	public ref class Withdraw : public System::Windows::Forms::Form
	{
	public:
		Withdraw(void)
		{
			InitializeComponent();
			//
			//TODO: �������� ��� ������������
			//
		}

	protected:
		/// <summary>
		/// ���������� ��� ������������ �������.
		/// </summary>
		~Withdraw()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::Button^  button1;
	protected:
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::TextBox^  textBox1;

	private:
		/// <summary>
		/// ������������ ���������� ������������.
		/// </summary>
		System::ComponentModel::Container ^components;

#pragma region Windows Form Designer generated code
		/// <summary>
		/// ��������� ����� ��� ��������� ������������ � �� ��������� 
		/// ���������� ����� ������ � ������� ��������� ����.
		/// </summary>
		void InitializeComponent(void)
		{
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->textBox1 = (gcnew System::Windows::Forms::TextBox());
			this->SuspendLayout();
			// 
			// button1
			// 
			this->button1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->button1->Location = System::Drawing::Point(87, 143);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(111, 32);
			this->button1->TabIndex = 14;
			this->button1->Text = L"�����";
			this->button1->UseVisualStyleBackColor = true;
			this->button1->Click += gcnew System::EventHandler(this, &Withdraw::button1_Click);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->label1->Location = System::Drawing::Point(111, 87);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(58, 20);
			this->label1->TabIndex = 13;
			this->label1->Text = L"�����";
			// 
			// textBox1
			// 
			this->textBox1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 12, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(204)));
			this->textBox1->Location = System::Drawing::Point(81, 111);
			this->textBox1->Name = L"textBox1";
			this->textBox1->Size = System::Drawing::Size(123, 26);
			this->textBox1->TabIndex = 12;
			// 
			// Withdraw
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::SystemColors::ActiveCaption;
			this->ClientSize = System::Drawing::Size(284, 262);
			this->Controls->Add(this->button1);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->textBox1);
			this->Name = L"Withdraw";
			this->StartPosition = System::Windows::Forms::FormStartPosition::CenterScreen;
			this->Text = L"Withdraw";
			this->Load += gcnew System::EventHandler(this, &Withdraw::Withdraw_Load);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void Withdraw_Load(System::Object^  sender, System::EventArgs^  e) 
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
					if (Data_base::client->get_money() - money > -1)
					{
						Data_base::client->payment(money);
						Data_base::client->add_transaction(-1 * money);
						MessageBox::Show("������ �����");
						this->Close();
					}
					else
					{
						MessageBox::Show("������������ �������", "������ ��������", MessageBoxButtons::OK, MessageBoxIcon::Error);
					}
				}
				else
				{
					if (Data_base::client_karta->get_money() - money > -1)
					{
						if (money < 5001)
						{
							Data_base::client_karta->payment(money);
							Data_base::client_karta->add_transaction(-1 * money);
							MessageBox::Show("������ �����");
							this->Close();
						}
						else
						{
							Data_base::client_karta->set_block(true);
							MessageBox::Show("����� ���� ������������� ���������� �� ���������� �������", "����������", MessageBoxButtons::OK, MessageBoxIcon::Information);
							this->Close();
						}
					}
					else
					{
						MessageBox::Show("������������ �������", "������ ��������", MessageBoxButtons::OK, MessageBoxIcon::Error);
					}
				}
			}
			else
			{
				MessageBox::Show("������� ���������� �����", "������ ��������", MessageBoxButtons::OK, MessageBoxIcon::Error);
			}
		}
		else
		{
			MessageBox::Show("������� ���������� �����", "������ ��������", MessageBoxButtons::OK, MessageBoxIcon::Error);
		}
	}
};
}
