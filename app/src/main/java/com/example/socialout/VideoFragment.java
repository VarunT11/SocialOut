package com.example.socialout;

import static com.google.android.exoplayer2.Player.REPEAT_MODE_ALL;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class VideoFragment extends Fragment {

    public VideoFragment() {
        // Required empty public constructor
    }

    private final static String POSITION_PARAM = "POSITION_PARAM";

    public static VideoFragment newInstance(int position) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION_PARAM, position);
        fragment.setArguments(args);
        return fragment;
    }

    private int position=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(POSITION_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MediaItem mediaItem = MediaItem.fromUri(Uri.parse("https://assets.mixkit.co/videos/preview/mixkit-taking-photos-from-different-angles-of-a-model-34421-large.mp4"));
        StyledPlayerView playerView = view.findViewById(R.id.player_view);

        ExoPlayer player = new ExoPlayer.Builder(requireContext()).build();

        playerView.setPlayer(player);
        playerView.setUseController(false);

        player.setMediaItem(mediaItem);
        player.setRepeatMode(REPEAT_MODE_ALL);
        player.prepare();
        player.play();

    }
}