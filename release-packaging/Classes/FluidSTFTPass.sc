FluidSTFTPass : FluidRTUGen {
	*ar { arg in = 0, windowSize= 1024, hopSize= -1, fftSize= -1, maxFFTSize = 16384;
		^this.multiNew('audio', in.asAudioRateInput(this), windowSize, hopSize, fftSize, maxFFTSize)
	}
	checkInputs {
		if(inputs.at(4).rate != 'scalar') {
			^": maxFFTSize cannot be modulated.";
			};
		^this.checkValidInputs
	}
}
