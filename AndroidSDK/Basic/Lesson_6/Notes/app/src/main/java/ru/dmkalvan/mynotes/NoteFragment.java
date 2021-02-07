package ru.dmkalvan.mynotes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class NoteFragment extends Fragment implements Constants {

    private TextView label, description, date, body;

    public NoteFragment() {
        // Required empty public constructor
    }

    public static NoteFragment newInstance(DataHandler sd) {
        NoteFragment fragment = new NoteFragment();
        Bundle args = new Bundle();
        args.putParcelable(YOUR_NOTES, sd);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        initView(view);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.new_note_menu, menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                return true;
            case R.id.action_clear:
                clearNote();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView(View view) {
        label = view.findViewById(R.id.note_label);
        description = view.findViewById(R.id.note_description);
        date = view.findViewById(R.id.note_date);
        body = view.findViewById(R.id.note_body);
        populateView();
    }

    private void populateView() {
        if (getArguments() != null) {
            DataHandler noteData = getArguments().getParcelable(YOUR_NOTES);
            label.setText(noteData.getNoteLabel());
            description.setText(noteData.getNoteDescription());
            date.setText(noteData.getNoteDate());
            body.setText(noteData.getNoteBody());
        }
    }

    private void clearNote() {
        label.setText(R.string.empty_string);
        description.setText(R.string.empty_string);
        date.setText(R.string.empty_string);
        body.setText(R.string.empty_string);
    }


}