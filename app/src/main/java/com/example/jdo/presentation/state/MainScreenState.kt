package com.example.jdo.presentation.state

import com.example.jdo.R

sealed class MainScreenState(val pointId: Int) {


    data class BoardScreen(
        val boardId: Int = R.id.boardPoint
    ) : MainScreenState(boardId)

    data class ProfileScreen(
        val profileId: Int = R.id.profilePoint
    ) : MainScreenState(profileId)

    data class ChallengeScreen(
        val challengeId: Int = R.id.challengePoint
    ) : MainScreenState(challengeId)

    data class MessageScreen(
        val messagedId: Int = R.id.messagePoint
    ) : MainScreenState(messagedId)

}