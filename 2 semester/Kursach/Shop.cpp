#include "Shop.h"

using namespace System;
using namespace System::Windows::Forms;
[STAThreadAttribute]
void Main3(array<String^>^ args)
{
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false);
	������::Shop form;
	Application::Run(%form);
}