package ru.dmkalvan.mynotes;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * С этого урока мы начинаем разработку приложения с заметками.
 * <p>
 * 1. Создайте класс данных со структурой заметок:
 * название заметки, описание заметки, дата создания и т. п.
 * <p>
 * 2. Создайте фрагмент для вывода этих данных.
 * <p>
 * 3. Встройте этот фрагмент в активити. У вас должен получиться экран с заметками, который мы
 * будем улучшать с каждым новым уроком.
 * <p>
 * 4. Добавьте фрагмент, в котором открывается заметка. По аналогии с примером из урока:
 * если нажать на элемент списка в портретной ориентации — открывается новое окно,
 * если нажать в ландшафтной — окно открывается рядом.
 * <p>
 * 5. * Разберитесь, как можно сделать, и сделайте корректировку даты создания при помощи DatePicker.
 * <p>
 * (*) Задача для дополнительного обучения.
 *
 * @author Dmitri Kalvan
 * @date 23.01.21
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}